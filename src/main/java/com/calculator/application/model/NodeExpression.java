package com.calculator.application.model;

public class NodeExpression {
    private char operator;
    private Double value;
    private NodeExpression left;
    private NodeExpression right;

    public NodeExpression(double value){
        this.value = value;
        this.operator = '\0';
    }

    public NodeExpression(char operator, NodeExpression left, NodeExpression right){
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public Double calculate(){
        if (operator == '\0') return value;

        Double leftVal = left.calculate();
        Double rightVal = right.calculate();

        switch (operator){
            case '+' -> {
                return leftVal+rightVal;
            }
            case '-' ->{
                return leftVal-rightVal;
            }
            case '*' ->{
                return leftVal*rightVal;
            }
            case '/' ->{
                if (rightVal == 0) {
                    throw new ArithmeticException("Division by 0 is not allowed");
                }
                return leftVal/rightVal;
            }
        }
        return 0.0;
    }
}
