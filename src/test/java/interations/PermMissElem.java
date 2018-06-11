package interations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by supi on 6/9/18.
 */
public class PermMissElem {

    @Test
    public void testPermMissElem() {
        Assert.assertEquals(5, solution(new int[] {1,2,3,4}));
    }

    private int solution(int[] ints) {
        long N = ints.length + 1;
        long total = (N * (N + 1) / 2);

        long sum = 0L;

        for (int i : ints) {
            sum += i;
        }

        return (int) (total - sum);
    }
}
