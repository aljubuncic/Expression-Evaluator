package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest {
    @Test
    void validateTest1(){
        assertThrows(java.lang.RuntimeException.class, () -> new ExpressionEvaluator().evaluate(""));
    }
    @Test
    void validateTest2(){
        assertThrows(RuntimeException.class, () -> new ExpressionEvaluator().evaluate("5*3"));
    }
    @Test
    void validateTest3(){
        assertThrows(RuntimeException.class, () -> new ExpressionEvaluator().evaluate("( 5 *3 )"));
    }

    @Test
    void validateTest4(){
        assertDoesNotThrow(() -> new ExpressionEvaluator().evaluate("( sqrt ( 5 ) * 3 )"));
    }
    @Test
    void validateTest5(){
        assertThrows(RuntimeException.class, () -> new ExpressionEvaluator().evaluate("( f * 3 )"));
    }
    @Test
    void validateTest6(){
        assertThrows(RuntimeException.class, ()-> new ExpressionEvaluator().evaluate("( 5 * ( 3 + 2 )"));
    }

    @Test
    void validateTest7(){
        assertThrows(RuntimeException.class,()->new ExpressionEvaluator().evaluate("( )"));
    }

    @Test
    void validateTest8(){
        assertThrows(RuntimeException.class,()->new ExpressionEvaluator().evaluate("( ( 3 + -456 ) + 76 )"));
    }

    @Test
    void validateTest9(){
        assertThrows( RuntimeException.class,()-> new ExpressionEvaluator().evaluate("( ( ( 5 + 3 ) ) )"));
    }
    @Test
    void validateTest10(){
        assertThrows(RuntimeException.class,()-> new ExpressionEvaluator().evaluate("( 2 / 0 )"),"Division by zero is not allowed");
    }

    @Test
    void evaluateTest1(){
        assertEquals(101,new ExpressionEvaluator().evaluate(" ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) "));
    }
    @Test
    void evaluateTest2(){
        assertEquals(2,new ExpressionEvaluator().evaluate("( sqrt 4 )"));
    }
    @Test
    void evaluateTest3(){
        assertEquals(5, new ExpressionEvaluator().evaluate("( sqrt ( 25 ) / 1 )"));
    }
    @Test
    void evaluateTest4(){
        assertEquals(-7, new ExpressionEvaluator().evaluate("( 5 - 12 )"));
    }
    @Test
    void evaluateTest5(){
        assertEquals(0, new ExpressionEvaluator().evaluate("( 0 / ( 5 / 7 ) )"));
    }
    @Test
    void evaluateTest6(){
        assertEquals(2, new ExpressionEvaluator().evaluate(" ( sqrt ( sqrt 16 ) )"));
    }
}
