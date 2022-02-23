package DP.first;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/
 *
 * @author 包成
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int[][] maxProfit = new int[prices.length][3];
        // 第二维含义: 未买
        maxProfit[0][0] = 0;
        // 第二维含义: 已买
        maxProfit[0][1] = -prices[0];
        // 第二维含义: 已卖
        maxProfit[0][2] = 0;

        int ret = 0;
        for (int i = 1; i < prices.length; ++i) {
            maxProfit[i][0] = maxProfit[i - 1][0];
            maxProfit[i][1] = Math.max(maxProfit[i - 1][1], maxProfit[i - 1][0] - prices[i]);
            maxProfit[i][2] = Math.max(maxProfit[i - 1][2], maxProfit[i - 1][1] + prices[i]);
            ret = Math.max(ret, maxProfit[i][2]);
        }

        return ret;
    }

}
