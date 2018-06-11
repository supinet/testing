package interations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by supi on 6/9/18.
 */
public class FrogJmp {

    @Test
    public void jumpTest() {
        Assert.assertEquals(1, solution(2, 3, 6));
    }

    public int solution(int X, int Y, int D) {
        return Double.valueOf(Math.ceil((Y - X) / (double) D)).intValue();
    }
}
