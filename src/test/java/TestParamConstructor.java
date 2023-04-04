import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TestParamConstructor {
    private Rational number1;
    private Rational number2;

    public TestParamConstructor(Rational number1, Rational number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    /*
    Тест-кейсы:
    - правильные одинаковые дроби
    - правильные одинаковые дроби с сокращением
    - одинаковые неправильные дроби с сокращением
    - ноль деленный на разные числа
    - кейс с отрицательными числами
    - кейс с отрицательным знаменателем
    - кейс с одинаковым числителем и знаменателем
     */
    @Parameterized.Parameters(name = "Case {index}: {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Rational(1, 2), new Rational(1, 2)},
                {new Rational(2, 4), new Rational(1, 2)},
                {new Rational(6, 2), new Rational(3, 1)},
                {new Rational(0, 2), new Rational(0, 1)},
                {new Rational(-5, -2), new Rational(5, 2)},
                {new Rational(1, -7), new Rational(-1, 7)},
                {new Rational(17, 17), new Rational(1, 1)}
        });
    }

    @Test
    public void constructor() {
        assertEquals("Standard constructor returns wrong numerator", number1.getNumerator(), number2.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", number1.getDenominator(), number2.getDenominator());
    }
}