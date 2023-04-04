import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ParameterizedTestConstructor {
    private int numerator;
    private int denominator;
    private int result_numerator;
    private int result_denominator;

    public ParameterizedTestConstructor(int numerator, int denominator, int result_numerator, int result_denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.result_numerator = result_numerator;
        this.result_denominator = result_denominator;
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
    @Parameterized.Parameters(name = "Case {index}: {0}/{1} = {2}/{3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 1, 2},
                {2, 4, 1, 2},
                {6, 2, 3, 1},
                {0, 2, 0, 1},
                {-5, -2, 5, 2},
                {1, -7, -1, 7},
                {17, 17, 1, 1}
        });
    }

    @Test
    public void constructor() {
        Rational number = new Rational(numerator, denominator);
        assertEquals("Standard constructor returns wrong numerator", result_numerator, number.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", result_denominator, number.getDenominator());
    }

}