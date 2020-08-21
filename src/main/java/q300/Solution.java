package q300;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。 子序列不要求连续.
 *
 * 设 dp[i] 表示以 nums[i] 结尾的最长升序子序列的长度.
 * dp[i] = max(dp[j]) + 1, 0 <= j < i, 且 nums[j] < nums[i]
 * @author admin
 * @date 2020/8/21 12:33
 */
public class Solution {

    public int longest(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }
            dp[i] = tmp + 1;
            longest = Math.max(dp[i], longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.longest(nums));

    }
}
