package interations;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by supi on 6/9/18.
 */
public class Equilibrium {

    @Test
    public void solutionTest() {
        Assert.assertEquals(2, solution(new int[]{1,2,3,5,6,7}));
    }

    public int solution(int[] A) {
        if (A.length == 2)
            return Math.abs(A[0]-A[1]);

        int [] s1 = new int[A.length-1];
        s1[0] = A[0];
        for (int i=1;i<A.length-1;i++) {
            s1[i] = s1[i-1] + A[i];
        }

        int [] s2 = new int[A.length-1];
        s2[A.length-2] = A[A.length-1];
        for (int i=A.length-3;i>=0;i--) {
            s2[i] = s2[i+1] + A[i+1];
        }

        int finalSum = Integer.MAX_VALUE;
        for (int j=0;j<s1.length;j++) {
            int sum = Math.abs(s1[j]-s2[j]);
            if (sum < finalSum)
                finalSum = sum;
        }
        return finalSum;
    }
}
