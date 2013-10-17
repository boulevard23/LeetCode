/**
 * Best Time to Buy and Sell Stock 2
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if ((prices[i + 1] - prices[i]) > 0) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
