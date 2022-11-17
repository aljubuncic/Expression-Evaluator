package ba.unsa.etf.rpr;

import java.lang.String;

public class App 
{
    public static void main( String[] args )
    {
        ExpressionEvaluator e = new ExpressionEvaluator();
        try{
            StringBuilder s = new StringBuilder();
            for (String arg : args)
                s.append(arg);
            System.out.println("Result of the expression is " + e.evaluate(s.toString()));
        }
        catch(RuntimeException r){
            System.out.println("Expression is not valid");
            System.out.println("Cause: " + r.getMessage());
        }

    }
}
