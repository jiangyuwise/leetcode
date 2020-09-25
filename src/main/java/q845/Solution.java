package q845;

/**
 * @author admin
 * @date 2020/9/23 09:45
 */
public class Solution {

    public int longestMountain(int[] nums) {
        int length = nums.length;
        int maxLength = 0;
        int[] left = new int[length];
        int[] right = new int[length];

        for (int i = 1; i < length; i ++) {
            if (nums[i] > nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; i --) {
            if (nums[i] > nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        for (int i = 0; i < length; i ++) {
            if (left[i] > 0 && right[i] > 0) {
                maxLength = Math.max(maxLength, left[i] + right[i] + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3};
        System.out.println(solution.longestMountain(nums));
    }
}
