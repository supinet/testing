package strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by supi on 6/9/18.
 */
public class ReserveTest {

    private Reverse reverse = new Reverse();

    @Test
    public void reverseTest() {
        String phrase = "the sky is blue";

        String phraseReversed = reverse.reverse(phrase);
        Assert.assertEquals(phraseReversed, "blue is sky the");
    }
}
