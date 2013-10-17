/**
 * Best Time to Buy and Sell Stock 3
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (prices.length == 0) return 0;
        int maxProfit = 0;
        int min = prices[0];
        int max = prices[prices.length - 1];
        int[] maxForward = new int[prices.length];
        int[] maxBackward = new int[prices.length];
        for (int i = 1; i < prices.length - 1; i++) {
            min = Math.min(min, prices[i]);
            maxForward[i] = Math.max(maxForward[i - 1], prices[i] - min);
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxBackward[i] = Math.max(maxBackward[i + 1], max - prices[i]);
            maxProfit = Math.max(maxProfit, maxForward[i] + maxBackward[i]);
        }
        return maxProfit;

    }
}
