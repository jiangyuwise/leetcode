package q62;

/**
 * 一个机器人位于 m x n 的网格左上角, 机器人每次只能向下或者向右移动一步
 * 试问机器人到达右下角有多少种不同的路径
 *
 * 动态规划, 设 dp[i][j] 表示到达 (i, j) 的路径总数
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * dp[i][0] = 1, i = 0 ... m - 1
 * dp[0][j] = 1, j = 0 ... n - 1
 *
 * 时间 O(m * n), 空间 O(m * n)
 * @author admin
 * @date 2020/5/15 21:59
 */
public class Solution {

    public int jump(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(3, 2));
    }
}
