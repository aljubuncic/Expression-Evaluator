package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest {
    @Test
    void validateTest1(){
        assertThrows(java.lang.RuntimeException.class, () -> new ExpressionEvaluator().validate(""));
    }
    @Test
    void validateTest2(){
        assertThrows(RuntimeException.class, () -> new ExpressionEvaluator().validate("5*3"));
    }
    @Test
    void validateTest3(){
        assertThrows(RuntimeException.class, () -> new ExpressionEvaluator().validate("( 5 *3 )"));
    }

    @Test
    void validateTest4(){
        assertDoesNotThrow(() -> new ExpressionEvaluator().validate("( sqrt ( 5 ) * 3 )"));
    }
    @Test
    void validateTest5(){
        assertThrows(RuntimeException.class, () -> new ExpressionEvaluator().validate("( f * 3 )"));
    }
    @Test
    void validateTest6(){
        assertThrows(RuntimeException.class, ()-> new ExpressionEvaluator().validate("( 5 * ( 3 + 2 )"));
    }

    @Test
    void validateTest7(){
        assertThrows(RuntimeException.class,()->new ExpressionEvaluator().validate("()"));
    }

    @Test
    void evaluateTest1(){
        assertEquals(101,new ExpressionEvaluator().evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }


}
