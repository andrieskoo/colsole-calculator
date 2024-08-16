package com.calculator.application;

import com.calculator.application.controller.CalculatorController;
import com.calculator.application.model.CalculatorModel;
import com.calculator.application.view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController controller = new CalculatorController(calculatorView, calculatorModel);

        controller.run();
    }
}