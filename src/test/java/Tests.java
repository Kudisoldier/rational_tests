import org.junit.*;
import static org.junit.Assert.*;

public class Tests {
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
    public void testLess() {
        Rational number1 = new Rational(1, 6);
        Rational number2 = new Rational(0, 5);
        assertFalse(number1.less(number2));
    }
}
