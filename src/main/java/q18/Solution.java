package q18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @date 2020/8/27 18:23
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < length - 3; first ++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            for (int second = first + 1; second < length - 2; second ++) {
                if (second > first + 1 && nums[second - 1] == nums[second]) {
                    continue;
                }
                int third = second + 1, fourth = length - 1;
                while (third < fourth) {
                    int tmp = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (tmp > target) {
                        fourth --;
                    } else if (tmp < target) {
                        third ++;
                    } else {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[first]);
                        item.add(nums[second]);
                        item.add(nums[third]);
                        item.add(nums[fourth]);
                        result.add(item);
                        while (third < fourth && nums[third] == nums[third + 1] ) {
                            third ++;
                        }
                        while (third < fourth && nums[fourth - 1] == nums[fourth]) {
                            fourth --;
                        }
                        third ++;
                        fourth --;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = solution.fourSum(nums, target);
        result.forEach(System.out::println);
    }
}
