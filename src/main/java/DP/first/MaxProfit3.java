package DP.first;

/**
 * 买卖股票的最佳时机 III
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author 包成
 */
public class MaxProfit3 {

    public int maxProfit(int[] prices) {
        // 一维: 第几天; 二维: 交易次数; 三维: 是否已买
        long[][][] profit = new long[prices.length][3][2];
        // 第0天的交易情况
        profit[0][0][0] = 0;
        profit[0][0][1] = -prices[0];
        profit[0][1][0] = Integer.MIN_VALUE;
        profit[0][1][1] = Integer.MIN_VALUE;
        profit[0][2][0] = Integer.MIN_VALUE;
        profit[0][2][1] = Integer.MIN_VALUE;

        long maxProfit = 0;
        for (int i = 1; i < profit.length; ++i) {
            // 不动
            profit[i][0][0] = profit[i - 1][0][0];
            // 前一天未买, 今天买入; 前一天已买
            profit[i][0][1] = Math.max(profit[i - 1][0][0] - prices[i], profit[i - 1][0][1]);

            // 前一天持有, 今天卖出, 交易次数++; 前一天未持有
            profit[i][1][0] = Math.max(profit[i - 1][0][1] + prices[i], profit[i - 1][1][0]);
            // 前一天未持有, 今天买入; 前一天已持有
            profit[i][1][1] = Math.max(profit[i - 1][1][0] - prices[i], profit[i - 1][1][1]);

            profit[i][2][0] = Math.max(profit[i - 1][1][1] + prices[i], profit[i - 1][2][0]);
            profit[i][2][1] = Math.max(profit[i - 1][2][0] - prices[i], profit[i - 1][2][1]);
            
            maxProfit = Math.max(maxProfit, Math.max(profit[i][1][0], profit[i][2][0]));
        }
        
        return (int) maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit3 maxProfit3 = new MaxProfit3();
        System.out.println(maxProfit3.maxProfit(new int[] {3,3,5,0,0,3,1,4}));
    }

}
