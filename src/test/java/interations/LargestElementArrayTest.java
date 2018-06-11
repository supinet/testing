package interations;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by supi on 6/9/18.
 */
public class LargestElementArrayTest {

    LargestElement largestElement = new LargestElement();

    @Test
    public void largestElementArray() {
        int[] array = {3,2,1,5,6,4};
        Assert.assertEquals(5, largestElement.largestElement(array, 2));
    }

    private class LargestElement {

        private int largestElement(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
}
