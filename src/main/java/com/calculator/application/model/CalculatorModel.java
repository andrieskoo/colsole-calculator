package com.calculator.application.model;

import java.util.Stack;

public class CalculatorModel implements Service{
    public static NodeExpression buildExpressionTree(String expression) {
        Stack<NodeExpression> nodeStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int countBrackets = 0;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isWhitespace(c)) continue;

            else if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                i--;
                nodeStack.push(new NodeExpression(Double.parseDouble(number.toString())));
            } else if (c == '(') {
                operatorStack.push(c);
                countBrackets++;
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    countBrackets--;
                    if (countBrackets<0){
                        throw new IllegalArgumentException("Brackets pairs count mismatch");
                    }
                    nodeStack.push(buildSubTree(operatorStack.pop(), nodeStack.pop(), nodeStack.pop()));
                }
                operatorStack.pop();
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && (precedence(operatorStack.peek()) >= precedence(c))) {
                    nodeStack.push(buildSubTree(operatorStack.pop(), nodeStack.pop(), nodeStack.pop()));
                }
                operatorStack.push(c);
            }
        }

        if (countBrackets != 0){
            throw new IllegalArgumentException("Brackets pairs count mismatch");
        }

        while (!operatorStack.isEmpty()) {
            nodeStack.push(buildSubTree(operatorStack.pop(), nodeStack.pop(), nodeStack.pop()));
        }
        return nodeStack.pop();
    }

    static boolean isOperator(char c) {
        switch (c) {
            case '+', '-', '*', '/' -> {
                return true;
            }
        }
        return false;
    }

    static int precedence(char c) {
        switch (c) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
        }
        return -1;
    }

    static NodeExpression buildSubTree(char operator, NodeExpression right, NodeExpression left){
        return new NodeExpression(operator, left, right);
    }
}
