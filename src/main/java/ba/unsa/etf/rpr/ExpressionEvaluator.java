package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ExpressionEvaluator {
    private Stack<Integer> operandStack;
    private Stack<String> operatorStack;

    /**
     * Initializes the expression with the argument provided.
     * Throws RunTimeException if the expression provided in the argument is not valid
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
            //to be implemented
        }
        return result;
    }
    public void validate(String expression) throws InvalidExpressionException{
        /**
         * checks if expression contains characters that are not "(", ")","+","-","*","/","sqrt"
         */
        String numbers="0123456789";
        if(!expression.contains("(") || !expression.contains(")") ||
                !(expression.contains("+") || expression.contains("-")
                        || expression.contains("*") || expression.contains("/")
                        || expression.contains("sqrt")))
            throw new InvalidExpressionException();

        ArrayList<String> oneCharacterStringArray= new ArrayList<>(Arrays.asList( expression.split(" ")));
        /**
         * checks if every character of expression is split by a space
         */
        //String[] characterArray=expression.split(" ");
        for(String s : oneCharacterStringArray){
            if(s.length()!=1)
                throw new InvalidExpressionException();
        }
        /**
         * check if expression has equal number of right and left parenthesis
         */
        Integer numOfLeftParenthesis=0;
        Integer numOfRightParenthesis=0;
        for(String s : oneCharacterStringArray){
            if(s.equals("("))
                numOfLeftParenthesis++;
            if(s.equals(")"))
                numOfRightParenthesis++;
        }
        if(!numOfLeftParenthesis.equals(numOfRightParenthesis))
            throw new InvalidExpressionException();
        }
}
