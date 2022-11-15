package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class  ExpressionEvaluator {
    private Stack<Double> operandStack;
    private Stack<String> operatorStack;

    /**
     * checks if expression is parenthesized from the outer sides
     */
    private void isParenthesizedFromOuterSides(ArrayList<String> stringsSeparatedBySpace){
        if(!stringsSeparatedBySpace.get(0).equals ("(") || !stringsSeparatedBySpace.get(stringsSeparatedBySpace.size()-1).equals( ")"))
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
     * checks if expression includes at least two numbers,
     * excludes the case when there is only one sqrt function representing the one expression
     * e.g. "( sqrt ( 5 ) )" or "( ( sqrt ( 5 ) ) * ( sqrt ( 3 ) ) )
     */
    private void doesHaveAtLeastTwoNumbers(ArrayList<String> stringsSeparatedBySpace) {
        int counterOfNumbers = 0;
        if(stringsSeparatedBySpace.contains("sqrt"))
           return;
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
     * Evaluates the expression provided in the argument and returns an Integer type result.
     * @param expression
     * @return Integer
     */
    public Double evaluate(String expression){
        Double result =null;
        for(String s : expression.split(" ")){

        }
        return result;
    }
    public void validate(String expression) {
        ArrayList<String> stringsSeparatedBySpace = new ArrayList<>(Arrays.asList(expression.split(" ")));

        isParenthesizedFromOuterSides(stringsSeparatedBySpace);
        doesContainInvalidCharacters(expression);
        isEverySegmentOfExpressionSeparatedCorrectly(stringsSeparatedBySpace);
        doesHaveAtLeastTwoNumbers(stringsSeparatedBySpace);
        doesHaveEqualNumberOfLeftAndRightParenthesis(stringsSeparatedBySpace);
    }
}
