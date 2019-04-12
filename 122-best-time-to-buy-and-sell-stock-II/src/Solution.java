public class Solution {
    /**
     * 可以将每天的价格画在折线图上
     * 将每一个两天之间递增的价格加起来，就是所求的结果
     *
     *
     * @param prices 价格数组
     * @return 最大收益
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1;i < prices.length;i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += (prices[i] - prices[i - 1]);
            }
        }
        return res;
    }
}