package q120;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * 设 dp[i][j] 表示到达 (i,j) 的最小路径和. i 表示层数, j 表示横坐标
 * dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + c[i][j]
 * 最左侧: dp[i][0] = dp[i - 1][0] + c[i][0]
 * 最右侧: dp[i][i] = dp[i - 1][i - 1] + c[i][i]
 * 只需要计算最后一层 dp 的最小值即可.
 * @author admin
 * @date 2020/8/21 11:40
 */
public class Solution {

    public int min(List<List<Integer>> triangle) {
        int level = triangle.size();
        int[][] dp = new int[level][level];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < level; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[level - 1][0];
        for (int i = 1; i < level; i++) {
            min = Math.min(min, dp[level - 1][i]);
        }
        return min;
    }
}
