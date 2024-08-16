package com.calculator.application.controller;

import com.calculator.application.model.CalculatorModel;
import com.calculator.application.model.Service;
import com.calculator.application.view.View;

import static com.calculator.application.view.Messages.BYE_MESSAGE;
import static com.calculator.application.view.Messages.CALCULATED_MESSAGE;
import static com.calculator.application.view.Messages.CALCULATION_INFO_MESSAGE;
import static com.calculator.application.view.Messages.HELP_MESSAGE;
import static com.calculator.application.view.Messages.MAIN_MENU;
import static com.calculator.application.view.Messages.WELCOME_MESSAGE;
import static com.calculator.application.view.Messages.WRONG_INPUT_MESSAGE;

public class CalculatorController {
    View view;
    Service service;

    InputHandler inputHandler;

    public CalculatorController(View view, Service service) {
        this.view = view;
        this.service = service;
        inputHandler = new InputHandler();
    }

    public void run() {
        view.print(WELCOME_MESSAGE);
        while (true){
            view.print(MAIN_MENU);
            String input = inputHandler.readLine();
            switch (input){
                case "?" -> {
                    view.print(HELP_MESSAGE);
                }
                case "q" ->{
                    view.print(BYE_MESSAGE);
                    return;
                }
                case "=" ->{
                    view.print(CALCULATION_INFO_MESSAGE);
                    var result = CalculatorModel.buildExpressionTree(inputHandler.readLine()).calculate();
                    view.print(String.format(CALCULATED_MESSAGE, result));

                }

                default -> {
                    view.print(WRONG_INPUT_MESSAGE);
                }
            }
        }
    }
}
