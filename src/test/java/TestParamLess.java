import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TestParamLess {
    private Rational number1;
    private Rational number2;
    private boolean result;

    public TestParamLess(Rational number1, Rational number2, boolean result) {
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
    }

    /*
    Тест-кейсы:
    - одинаковый знаменатель, позитивный кейс
    - одинаковый знаменатель, негативный кейс
    - равенство
    - одинаковы числитель позитивный кейс
    - одинаковый числитель негативный кейс
    - негативный кейс
     */
    @Parameterized.Parameters(name = "Case {index}: {0} < {1} should be {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Rational(1, 17), new Rational(2, 17), true},
                {new Rational(2, 17), new Rational(1, 17), false},
                {new Rational(17, 17), new Rational(17, 17), false},
                {new Rational(5, 3), new Rational(5, 2), true},
                {new Rational(5, 2), new Rational(5, 3), false},
                {new Rational(1, 6), new Rational(0, 5), false}
        });
    }

    @Test
    public void constructor() {
        assertEquals(number1.toString() + " is not less " + number2.toString(), number1.less(number2), result);
    }
}