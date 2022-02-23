package Greedy.first;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author 包成
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 在 i-1 天买入 i天卖出, 如果利润大于0, 则保存
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    private int maxProfitV2(int[] prices) {
        // 第一天持有最大收益
        int dp1 = -prices[0];
        // 第一天不持有最大收益
        int dp2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int newDp1 = Math.max(dp1, dp2 - prices[i]);
            int newDp2 = Math.max(dp1 + prices[i], dp2);
            dp1 = newDp1;
            dp2 = newDp2;
        }
        return dp2;
    }

}
