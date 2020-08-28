package q34;

import java.util.Arrays;

/**
 * @author admin
 * @date 2020/8/28 19:52
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int leftIndex = search(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return result;
        }
        result[0] = leftIndex;
        result[1] = search(nums, target, false) - 1;
        return result;
    }

    public int search(int[] nums, int target, boolean left) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int[] result = solution.searchRange(nums, 8);
        System.out.println(Arrays.toString(result));
    }
}
