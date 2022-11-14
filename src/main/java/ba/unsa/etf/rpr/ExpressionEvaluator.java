package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    private Stack<Integer> operandStack;
    private Stack<Character> operatorStack;

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
    public Integer evaluate(){
        return 0;
    }
}
