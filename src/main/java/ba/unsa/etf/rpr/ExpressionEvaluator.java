package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class  ExpressionEvaluator {
    private Stack<Double> operandStack;
    private Stack<String> operatorStack;

    /**
     * Validates the specified arithmetic expression.
     * Does not include cases of excess parenthesis or division by zero.
     *
     * @param expression
     */
    private void validate(String expression) {
        ArrayList<String> stringsSeparatedBySpace = new ArrayList<>(Arrays.asList(expression.split(" ")));

        isParenthesizedFromOuterSides(stringsSeparatedBySpace);
        doesContainInvalidCharacters(expression);
        isEverySegmentOfExpressionSeparatedCorrectly(stringsSeparatedBySpace);
        doesHaveAtLeastTwoNumbers(stringsSeparatedBySpace);
        doesHaveEqualNumberOfLeftAndRightParentheses(stringsSeparatedBySpace);
    }

    /**
     * Checks if expression is parenthesized from the outer sides.
     *
     * @param stringsSeparatedBySpace
     */
    private void isParenthesizedFromOuterSides(ArrayList<String> stringsSeparatedBySpace) {
        if (!stringsSeparatedBySpace.get(0).equals("(") || !stringsSeparatedBySpace.get(stringsSeparatedBySpace.size() - 1).equals(")"))
            throw new RuntimeException();
    }

    /**
     * Checks if expression contains characters that are not "(", ")","+","-","*","/","sqrt".
     *
     * @param expression
     */

    private void doesContainInvalidCharacters(String expression) {
        if (!expression.contains("(") || !expression.contains(")") ||
                !(expression.contains("+") || expression.contains("-")
                        || expression.contains("*") || expression.contains("/")
                        || expression.contains("sqrt")))
            throw new RuntimeException();
    }

    /**
     * Checks if every segment (parenthesis, operator or operand) of expression
     * is correctly separated from each other by a space character.
     *
     * @param stringsSeparatedBySpace
     */
    private void isEverySegmentOfExpressionSeparatedCorrectly(ArrayList<String> stringsSeparatedBySpace) {

        for (String s : stringsSeparatedBySpace) {
            try {
                Integer.parseInt(s);
                if (s.charAt(0) == '+' || s.charAt(0) == '-')
                    throw new NumberFormatException();
            } catch (NumberFormatException n) {
                if (s.length() != 1 && !s.equals("sqrt"))
                    throw new RuntimeException();
            }
        }
    }

    /**
     * Checks if expression includes at least two numbers.
     * Excludes the case when there is only one sqrt function representing the one expression
     * e.g. "( sqrt 5  )" or "( sqrt 5 ) * ( sqrt 3 )"
     * @param stringsSeparatedBySpace
     */
    private void doesHaveAtLeastTwoNumbers(ArrayList<String> stringsSeparatedBySpace) {

        int counterOfNumbers = 0;
        if (stringsSeparatedBySpace.contains("sqrt"))
            return;
        for (String s : stringsSeparatedBySpace) {
            if (s.length() != 0 && Character.isDigit(s.charAt(0)))
                counterOfNumbers++;
        }
        if (counterOfNumbers < 2)
            throw new RuntimeException();
    }

    /**
     * Checks if expression has equal number of right and left parentheses.
     * @param stringsSeparatedBySpace
     */
    private void doesHaveEqualNumberOfLeftAndRightParentheses(ArrayList<String> stringsSeparatedBySpace) {
        Integer numOfLeftParenthesis = 0;
        Integer numOfRightParenthesis = 0;
        for (String s : stringsSeparatedBySpace) {
            if (s.equals("("))
                numOfLeftParenthesis++;
            if (s.equals(")"))
                numOfRightParenthesis++;
        }
        if (!numOfLeftParenthesis.equals(numOfRightParenthesis))
            throw new RuntimeException();
    }

    /**
     * Checks if the provided string represents any of the operators "+" "-" "*" "/" "sqrt".
     *
     * @param s
     * @return boolean
     */
    private boolean isOperator(String s) {
        return "+ - * / sqrt".contains(s);
    }

    /**
     * Performs an arithmetic operation specified by operator with the specified operand(s).
     *
     * @param secondOperand
     * @param operator
     */
    private void performAnArithmeticOperation(Double secondOperand, String operator) {
        switch (operator) {
            case "+":
                operandStack.push(secondOperand + operandStack.pop());
                break;
            case "-":
                operandStack.push(operandStack.pop() - secondOperand);
                break;
            case "*":
                operandStack.push(secondOperand * operandStack.pop());
                break;
            case "/":
                if (secondOperand.equals((double) 0))
                    throw new RuntimeException("Division by zero is not allowed");
                operandStack.push(operandStack.pop() / secondOperand);
                break;
            case "sqrt":
                operandStack.push(Math.sqrt(secondOperand));
                break;
        }
    }

    /**
     * Initializes stacks for operands and operators to empty stacks.
     */

    public ExpressionEvaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    /**
     * Evaluates the expression provided in the argument and returns an Integer type result.
     * Throws RuntimeException if there are excess parentheses or division by zero.
     *
     * @param expression
     * @return Integer
     */
    public Double evaluate(String expression) {
        this.validate(expression.trim());
        for (String s : expression.trim().split(" ")) {
            if (s.equals("(")) ;
            else if (isOperator(s))
                operatorStack.push(s);
            else if (s.equals(")")) {
                if (operatorStack.isEmpty())
                    // if this is true then it means there are excess parentheses which is invalid expression
                    // e.g. ( ( 6 + 9 ) )
                    throw new RuntimeException();
                String operator = operatorStack.pop();
                Double secondOperand = operandStack.pop();
                performAnArithmeticOperation(secondOperand, operator);
            } else operandStack.push(Double.parseDouble(s));
        }
        return operandStack.pop();
    }

}
