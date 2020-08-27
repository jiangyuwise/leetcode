package q16;

import java.util.Arrays;

/**
 * 寻找 3 个数, 使其和最接近 target, 返回这 3 个数的和.
 * @author admin
 * @date 2020/8/20 16:40
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = 100_0000;
        for (int first = 0; first < nums.length; first++) {
            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(closet - target)) {
                    closet = sum;
                }
                if (sum < target) {
                    while (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    second ++;
                } else {
                    while (second < third && nums[third - 1] == nums[third]) {
                        third --;
                    }
                    third --;
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
