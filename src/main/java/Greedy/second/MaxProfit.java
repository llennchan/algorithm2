package Greedy.second;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int notHold = 0;
        for (int i = 1; i < prices.length; i++) {
            int newHold = Math.max(hold, notHold - prices[i]);
            int newNotHold = Math.max(prices[i] + hold, notHold);
            hold = newHold;
            notHold = newNotHold;
        }
        return notHold;
    }

}
