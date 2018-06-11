package interations;

import org.junit.Test;

/**
 * Created by supi on 6/9/18.
 */
public class MedianArrayTest {

    MedianArray medianArray = new MedianArray();

    @Test
    public void medianArray() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {4, 2, 1, 9};
        medianArray.findMedian(nums1, nums2);
    }

    private class MedianArray {

        private double findMedian(int[] nums1, int[] nums2) {

            int le = nums1.length + nums2.length;
            int l = (le) / 2;

            int[] arr = new int[l + 1];

            int j = 0;
            int k = 0;

            return 0;
        }
    }
}
