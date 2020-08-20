package q64;

/**
 * 给定一个包含非负整数的 m x n 网格, 找出一条从左上角到右下角的路径, 使得路径上的数字综合最小
 *
 * 设dp[i][j] 表示到 (i,j) 的最小数字和
 * dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
 * @author admin
 * @date 2020/5/15 22:14
 */
public class Solution {

    public int jump(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.jump(grid));
    }
}
