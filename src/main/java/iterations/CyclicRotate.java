package iterations;

/**
 * Created by supi on 6/4/18.
 */
public class CyclicRotate {

    public static void rotate(int[] arr, int order) {
        if (arr == null || order < 0) {
            throw new IllegalArgumentException("The array must be non-null and the order must be non-negative");
        }

        int offset = arr.length - order % arr.length;
        if (offset > 0) {
            int[] copy = arr.clone();
            for (int i = 0; i < arr.length; ++i) {
                int j = (i + offset) % arr.length;
                arr[i] = copy[j];
            }
        }
    }

    public int[] rotateByN(int[] arrTest, int k) {
        int[] result = new int[arrTest.length];
        for (int i = 0; i < arrTest.length; i++) {
            int idx = (i + k) % arrTest.length;
            result[idx] = arrTest[i];
        }
        return result;
    }
}
