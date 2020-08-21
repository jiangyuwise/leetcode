package q121;

/**
 * 买卖股票的最佳时期
 * @author admin
 * @date 2020/8/21 11:14
 */
public class Solution {

    public int max(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) { // 寻找最低价格
                minPrice = prices[i];
            } else if (maxProfit < prices[i] - minPrice) {  // 或者计算最大利润
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.max(prices));
    }
}
