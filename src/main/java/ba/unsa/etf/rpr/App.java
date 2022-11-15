package ba.unsa.etf.rpr;

import java.lang.String;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExpressionEvaluator e = new ExpressionEvaluator();
        try{
            StringBuilder s = new StringBuilder();
            for (String arg : args)
                s.append(arg).append(" ");
            e.validate(s.toString());
            System.out.println("Expression is valid");
            System.out.println("Result of the expression is " + e.evaluate(s.toString()));
        }
        catch(RuntimeException r){
            System.out.println("Expression is not valid");
        }

    }
}
