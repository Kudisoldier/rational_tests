import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class ParameterizedTestLess {
    private Rational number1;
    private Rational number2;

    public ParameterizedTestLess(Rational number1, Rational number2) {
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
                {new Rational(1, 2), new Rational(1, 2)}
        });
    }

    @Test
    public void constructor() {
        assertTrue(number1.toString() + " is not less " + number2.toString(), number1.less(number2));
    }
}