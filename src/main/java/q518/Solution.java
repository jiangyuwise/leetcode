package q518;

/**
 * 给定不同面额的硬币和一个总金额, 计算出可以凑成总金额的硬币组合数
 * 如果无法凑成, 返回 0
 *
 * dp[i] = dp[i] + dp[i - coin]
 * 动态规划
 * @author admin
 * @date 2020/8/24 18:06
 */
public class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
