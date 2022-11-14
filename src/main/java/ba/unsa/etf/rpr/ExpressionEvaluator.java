package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ExpressionEvaluator {
    private Stack<Integer> operandStack;
    private Stack<String> operatorStack;

    /**
     * checks if expression is parenthesized from the outer sides
     */
    private void isParenthesizedFromOuterSides(String expression){
        if(expression.charAt(0) != '(' || expression.charAt(expression.length()-1)!= ')')
            throw new RuntimeException();
    }

    /**
     * checks if expression contains characters that are not "(", ")","+","-","*","/","sqrt"
     */

    private void doesContainInvalidCharacters(String expression){
        if(!expression.contains("(") || !expression.contains(")") ||
                !(expression.contains("+") || expression.contains("-")
                        || expression.contains("*") || expression.contains("/")
                        || expression.contains("sqrt")))
            throw new RuntimeException();
    }

    /**
     * checks if every segment (parenthesis, operator or operand) of expression
     * is separated from each other by a space character
     */
    private void isEverySegmentOfExpressionSeparatedCorrectly(ArrayList<String> stringsSeparatedBySpace) {
        for (String s : stringsSeparatedBySpace) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException n) {
                if (s.length() != 1 && !s.equals("sqrt"))
                    throw new RuntimeException();
            }
        }
    }

    /**
     * checks if expression includes at least two numbers
     */
    private void doesHaveAtLeastTwoNumbers(ArrayList<String> stringsSeparatedBySpace) {
        int counterOfNumbers = 0;
        for (String s : stringsSeparatedBySpace) {
            if (Character.isDigit(s.charAt(0)))
                counterOfNumbers++;
        }
        if (counterOfNumbers < 2)
            throw new RuntimeException();
    }

    /**
     * checks if expression has equal number of right and left parenthesis
     */
    private void doesHaveEqualNumberOfLeftAndRightParenthesis(ArrayList<String> stringsSeparatedBySpace){
        Integer numOfLeftParenthesis=0;
        Integer numOfRightParenthesis=0;
        for(String s : stringsSeparatedBySpace){
            if(s.equals("("))
                numOfLeftParenthesis++;
            if(s.equals(")"))
                numOfRightParenthesis++;
        }
        if(!numOfLeftParenthesis.equals(numOfRightParenthesis))
            throw new RuntimeException();
    }
    /**
     * Initializes stacks for operands and operators to empty stacks.
     */

    public ExpressionEvaluator(){
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    /**
     * Evaluates the expression and returns an Integer type result.
     * @return Integer
     */
    public Double evaluate(String expression){
        Double result =null;
        for(String s : expression.split(" ")){

        }
        return result;
    }
    public void validate(String expression) {
        isParenthesizedFromOuterSides(expression);
        doesContainInvalidCharacters(expression);

        ArrayList<String> stringsSeparatedBySpace = new ArrayList<>(Arrays.asList(expression.split(" ")));

        isEverySegmentOfExpressionSeparatedCorrectly(stringsSeparatedBySpace);
        doesHaveAtLeastTwoNumbers(stringsSeparatedBySpace);
        doesHaveEqualNumberOfLeftAndRightParenthesis(stringsSeparatedBySpace);
    }
}
