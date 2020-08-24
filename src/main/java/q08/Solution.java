package q08;

/**
 * 兑换硬币, 数量不限, 币值有 25, 10, 5, 1, 求金额 n 有多少种表示方法.
 *
 * 动态规划
 * @author admin
 * @date 2020/8/24 17:51
 */
public class Solution {

    public int waysToChange(int n) {
        int[] coins =  {25, 10, 5, 1};
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % mod;
            }
        }
        return dp[n];
    }
}
