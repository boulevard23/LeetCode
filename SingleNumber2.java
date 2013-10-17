/**
 * Single Number 2
 *
 * Given an array of integers, every element appears three times except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 */

public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int k = 0;
            for (int j = 0; j < A.length; j++) {
                k += (A[j] >> i) & 1;
            }
            if (k % 3 > 0) result += 1 << i;
        }
        return result;
    }
}
