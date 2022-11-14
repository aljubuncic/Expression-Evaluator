package ba.unsa.etf.rpr;

public class InvalidExpressionException extends Exception{
    public InvalidExpressionException(){
        super();
    }
    @Override
    public String getMessage() {
        return "The expression is not valid";
    }
}
