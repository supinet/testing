package iterations;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

 For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

 Write a function:

 class Solution { public int solution(int N); }

 that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

 For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

 Assume that:

 N is an integer within the range [1..2,147,483,647].
 Complexity:

 expected worst-case time complexity is O(log(N));
 expected worst-case space complexity is O(1).


 Counting bits
 When the main task involves bits, it's good to look for opportunities for bit shifting operations. For example, you can check if the last bit is 1 with:

 if ((num & 1) == 1) {
 And you can shift the bits to the right by 1 with:

 num >>= 1;
 These are more natural in this context than num % 2 == 1 and num /= 2. And often might perform better too.

 Avoid flag variables
 When possible, it's good to avoid flag variables.

 You are using flag to indicate if you've ever seen a 1-bit. For each 0-bit, you check if the flag is set. This is inefficient.

 There is a way to avoid this flag. You can first shift until the first 1-bit. That is, skip all the trailing zeros.

 int work = N;
 while (work > 0 && (work & 1) == 0) {
 work >>= 1;
 }
 At this point we have reached a 1, or the end. It's safe to shift one more time, in case the last bit is 1.

 work >>= 1;
 After this, we can start counting zeros, and reset the count every time we see a 1. There's no more need for a flag.

 Naming
 temp is not a great name for a variable that counts zeros. How about zeros instead?

 Alternative implementation
 Putting the above tips together (and a bit more), this is a bit simpler and shorter:

 public int solution(int N) {
 int work = N;
 while (work > 0 && (work & 1) == 0) {
 work >>= 1;
 }
 work >>= 1;

 int max = 0;
 int zeros = 0;

 while (work > 0) {
 if ((work & 1) == 0) {
 zeros++;
 } else {
 max = Math.max(max, zeros);
 zeros = 0;
 }
 work >>= 1;
 }
 return max;
 }

 */

import java.io.Serializable;

/**
 * Created by supi on 6/1/18.
 */
public class BinaryGap implements Serializable {

    private static final Long serialVersionUID = 1L;

    public int solution(int N) {

        int r = N;

        while (r > 0 && (r & 1) == 0) {
            r >>= 1;
        }
        r >>= 1;

        int max = 0;
        int zeros = 0;

        while (r > 0) {
            if ((r & 1) == 0) {
                zeros++;
            } else {
                max = Math.max(max, zeros);
                zeros = 0;
            }
            r >>= 0;
        }
        return max;
    }

    public int solution2(int N) {

        int gap = 0;
        int current = -1;

        while (N > 0) {
            if (N % 2 != 0) {
                if(current > gap)
                    gap = current;
                current = 0;
            } else if (current >= 0) {
                current++;
            }
            N = N >> 1;
        }

        return gap;
    }
}
