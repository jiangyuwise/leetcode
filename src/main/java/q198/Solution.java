package q198;

/**
 * @author admin
 * @date 2020/9/9 18:46
 */
public class Solution {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int p = nums[0];
        int q = Math.max(nums[0], nums[1]);
        int r;
        for (int i = 2; i < length; i ++) {
            r = Math.max(p + nums[i], q);
            p = q;
            q = r;
        }
        return q;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));
    }
}
