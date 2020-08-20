package q16;

import java.util.Arrays;

/**
 * @author admin
 * @date 2020/8/20 16:40
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = 1000_0000;
        for (int first = 0; first < nums.length; first++) {
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(closet - target)) {
                    closet = sum;
                }
                if (sum > target) {
                    int tmpThird = third - 1;
                    while (second < tmpThird && nums[tmpThird] == nums[third]) {
                        tmpThird--;
                    }
                    third = tmpThird;
                } else {
                    int tmpSecond = second + 1;
                    while (tmpSecond < third && nums[tmpSecond] == nums[second]) {
                        tmpSecond++;
                    }
                    second = tmpSecond;
                }
            }
        }
        return closet;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(solution.threeSumClosest(nums, 1));
    }
}
