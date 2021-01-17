package Junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
        System.out.println("BeforeEach --> setUp()");
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
        System.out.println("AfterEach --> tearDown()");
    }

    @Test
    void calculatorNotNullTest() {
        assertNotNull(calculator);
    }

    @Test
    void calculatorNullTest() {
        assertNotNull(calculator);
    }


    @Test
    void addTest() {
        int numero1 = 5;
        int numero2 = 3;
        int total;

        total = calculator.add(numero1,numero2);

        assertEquals(total, 8);
    }

    @Test
    void subtractTest() {
        int numero1 = 5;
        int numero2 = 3;
        int total;

        total = calculator.subtract(numero1,numero2);

        assertEquals(total, 2);
    }

    @Test
    void divideTest(){
        int numero1 = 10;
        int numero2 = 2;
        int total;

        total = calculator.divide(numero1,numero2);

        assertEquals(total, 5);
    }
    @Test
    void divideForCeroTest(){
        int numero1 = 10;
        int numero2 = 0;
        assertThrows(ArithmeticException.class, ()-> calculator.divide(numero1,numero2), "no se puede dividir por5 cero");
    }


    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={3}")
    @MethodSource("addProviderData")
    public void addParameterizedTest(int a, int b, int sum){
        assertEquals(sum, calculator.add(a,b));
    }

    private static Stream<Arguments> addProviderData(){
        return Stream.of(
                Arguments.of(6,2,8),
                Arguments.of(-6,-2,-8),
                Arguments.of(6,-2,4),
                Arguments.of(-6,2,-4),
                Arguments.of(6,0,6)
        );
    }

}