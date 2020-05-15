package q70;

/**
 * 青蛙跳台阶问题: 青蛙一次可以跳 1 级台阶, 也可以跳 2 级台阶, 求该青蛙跳上 n 级的台阶有多少种跳法
 * @author admin
 * @date 2020/5/15 21:29
 */
public class Solution {

    public int jump(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(1));
    }
}
