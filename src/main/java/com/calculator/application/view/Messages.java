package com.calculator.application.view;

public class Messages {
    public static String CALCULATION_INFO_MESSAGE = """
            Please write expression to calculate:
            """;
    public static String WELCOME_MESSAGE = """
            Welcome to console calculator
            """;
    public static String MAIN_MENU = """
            Chose actions:
                  = - perform calculations
                  ? - help
                  q - exit
            Please make your choose:\\s
            
            """;
    public static String HELP_MESSAGE = """
            For calculate expression, you should input your expression and pres Enter.
            Example:
                Please write expression to calculate:
                (2+3)*3+6/2
                pres "Enter"
                The result of your expression is: 18.0
            
            """;
    public static String BYE_MESSAGE = """
            Thank for trying our calculator.
            Bye.
            
            """;
    public static String CALCULATED_MESSAGE = """
            The result of your expression is: %s
                      
            """;
    public static String WRONG_INPUT_MESSAGE = """
            You enter the incorrect message
                      
            """;
}
