import iterations.BinaryGap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by supi on 6/1/18.
 */
public class BinaryGapTest {

    @Test
    public void solution() {
        BinaryGap binaryGap = new BinaryGap();
        binaryGap.solution(2);
        Assert.assertNotNull(binaryGap);
    }

    @Test
    public void solution2() {
        BinaryGap binaryGap = new BinaryGap();
        binaryGap.solution2(2);
        Assert.assertNotNull(binaryGap);
    }

}
