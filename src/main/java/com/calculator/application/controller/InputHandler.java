package com.calculator.application.controller;

import java.util.Scanner;

public class InputHandler {
    Scanner scanner = new Scanner(System.in);

    public String readLine(){
        return scanner.nextLine();
    }
}
