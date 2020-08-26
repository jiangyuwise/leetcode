package q120;

import java.util.List;

/**
 * @author admin
 * @date 2020/8/26 11:37
 */
public class Solution2 {

    public int min(List<List<Integer>> triangle) {
        int level = triangle.size();
        int[] dp = new int[level];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < level; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int min = dp[0];
        for (int tmp : dp) {
            min = Math.min(min, tmp);
        }
        return min;
    }
}
