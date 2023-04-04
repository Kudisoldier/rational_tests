import org.junit.*;
import static org.junit.Assert.*;

public class TestUnit {
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        new Rational(1, 0);
    }

    @Test()
    public void testToString() {
        Rational standard = new Rational(1, 5);
        assertEquals("String representation are wrong", standard.toString(), "1/5");
    }

    @Test()
    public void testEquals() {
        Rational number1 = new Rational(1, 5);
        Rational number2 = new Rational(2, 10);
        assertEquals("Numbers are different", number1, number2);
    }

    @Test(expected = ArithmeticException.class)
    public void testSetZeroDenominator() {
        Rational number = new Rational(1, 1);
        number.setDenominator(0);
    }

    @Test()
    public void testLessOrEquals() {
        Rational number1 = new Rational(1, 4);
        Rational number2 = new Rational(1, 4);
        assertTrue("Numbers are not lessOrEqual", number1.lessOrEqual(number2));
    }

    @Test()
    public void testPlus() {
        Rational number1 = new Rational(1, 5);
        Rational number2 = new Rational(1, 5);
        assertEquals("Plus are wrong", number1.plus(number2), new Rational(2, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void testMultiplyNegative() {
        Rational number1 = new Rational(1, 4);
        Rational number2 = new Rational(4, 2);
        number2.setDenominator(0);
        assertEquals("Multiplication are wrong", number1.multiply(number2), new Rational());
    }

    @Test()
    public void testMultiplyPositive() {
        Rational number1 = new Rational(1, 4);
        Rational number2 = new Rational(4, 2);
        assertEquals("Multiplication are wrong", number1.multiply(number2), new Rational(1, 2));
    }

    @Test()
    public void testMinus() {
        Rational number1 = new Rational(4, 2);
        Rational number2 = new Rational(1, 4);
        assertEquals("Minus are wrong", number1.minus(number2), new Rational(7, 4));
    }

    @Test()
    public void testDivide() {
        Rational number1 = new Rational(5, 1);
        Rational number2 = new Rational(1, 2);
        assertEquals("Division are wrong", number1.divide(number2), new Rational(10, 1));
    }
}
