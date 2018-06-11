package strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by supi on 6/9/18.
 */
public class StringToIntegerTest {

    @Test
    public void stringToInteger() {
        String numbers = "1234556";
        Assert.assertEquals(1234556, convertStrToInteger(numbers));
    }

    private int convertStrToInteger(String numbers) {
        return Integer.parseInt(numbers);
    }
}
