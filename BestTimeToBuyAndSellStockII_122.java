package leetcode;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class BestTimeToBuyAndSellStockII_122 {
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int result = prices[i + 1] - prices[i];
            if (result > 0) {
                res += result;
            }
        }
        return res;
    }

}
