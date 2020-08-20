package q53;

/**
 * 计算最大子序列和
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 动态规划: 设 dp[i] 表示以 nums[i] 结尾的连续子序列最大和
 * 动态规划转移方程: dp[i] = max(dp[i - 1] + nums[i], nums[i])
 * 时间 O(n), 空间 O(n)
 *
 * 如果使用一个变量 pre 表示 dp[i - 1], 则空间复杂度变为 O(1)
 * @author admin
 * @date 2020/8/19 23:16
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            if (max < pre) {
                max = pre;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int max = solution.maxSubArray(nums);
        System.out.println(max);
    }
}
