package q53;

/**
 * @author admin
 * @date 2020/8/24 09:40
 */
public class Solution2 {

    public int max(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
