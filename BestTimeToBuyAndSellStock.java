/**
 * Best Time to Buy and Sell Stock
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */

public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            tmp += prices[i + 1] - prices[i];
            if (tmp < 0) tmp = 0;
            else if (tmp > max) max = tmp;
        }

        return max;
    }
}
