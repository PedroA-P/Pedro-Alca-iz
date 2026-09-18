import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;

import com.introsoftware.*;
public class CalculatorTestCase {
public Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    
    void multiplyTest() {
        assertEquals(6, calculator.multiply(2, 3));
    }
   @Test 
   void multiplyZeroTest() {
        assertEquals(0, calculator.multiply(0, 3));
    } 
    @Test 
    void multiplyNegativeTest() {
        assertEquals(-6, calculator.multiply(-2, 3));
    }
    @Test 
    void concatTest() {
        assertEquals("HelloWorld", calculator.concat("Hello", "World"));
    }   
    @Test 
    void concatNullTest() {
        assertEquals(Calculator.EMPTY, calculator.concat("Hello", null));
    }
    @Test 
    void sumTest() {
        assertEquals(5.0, calculator.sum(2.0, 3.0));
    }
    @Test 
    void sumNegativeTest() {
        assertEquals(-1.0, calculator.sum(2.0, -3.0));
    }
    @Test 
    void discountTest() {
        assertEquals(90.0, calculator.discount(100.0, 10.0));
    }
    @Test 
    void discountZeroTest() {
        assertEquals(100.0, calculator.discount(100.0, 0.0));
    }
    @Test 
    void discounthundredTest() {
        assertEquals(0.0, calculator.discount(100.0, 100.0));
    }
    @Test 
    void discountInvalidPercentTest() {
        try {
            calculator.discount(100.0, 110.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Percentage must be between 0 and 100", e.getMessage());
        }
    }
     @Test
    public void calculateTotalReturnsCorrectSum() {

        List<Double> amounts = Arrays.asList(
                10.0,
                20.0,
                30.0
        );

        double result = calculator.calculateTotal(amounts);

        assertEquals(60.0, result);
    }
      @Test
    public void calculateTotalEmptyListReturnsZero() {

        List<Double> amounts = Collections.emptyList();

        double result = calculator.calculateTotal(amounts);

        assertEquals(0.0, result);
    }

    }
