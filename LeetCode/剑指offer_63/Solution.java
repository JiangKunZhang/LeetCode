package 剑指offer_63;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/7 18:05
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > max) {
                max = prices[i] - minPrice;
            }
        }
        return max;
    }
}
