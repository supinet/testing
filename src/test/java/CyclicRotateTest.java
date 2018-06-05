import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static iterations.CyclicRotate.rotate;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by supi on 6/4/18.
 */
public class CyclicRotateTest {

    @Test
    public void collectionRotate() {
        Integer[] arr = {0, 1, 2, 3, 4};
        Integer[] expected = {3, 4, 0, 1, 2};
        Collections.rotate(Arrays.asList(arr), 2);
        Assert.assertNotNull(arr);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testRotateBy2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {7, 8, 1, 2, 3, 4, 5, 6};
        rotate(arr, 2);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRotateBy3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {6, 7, 8, 1, 2, 3, 4, 5};
        rotate(arr, 3);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRotateByLength() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = arr.clone();
        rotate(arr, arr.length);
        assertArrayEquals(expected, arr);
        rotate(arr, arr.length * 3);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testRotateByZero() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = arr.clone();
        rotate(arr, 0);
        assertArrayEquals(expected, arr);
    }

}
