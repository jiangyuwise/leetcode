package q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**在数组中寻找三个不同的数, 使得 a + b + c = 0
 * @author admin
 * @date 2020/8/20 12:56
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1, third = length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum > 0) {
                    third --;
                } else if (sum < 0) {
                    second ++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                    while (second < third && nums[second] == nums[second + 1]) {
                        second ++;
                    }
                    while (second < third && nums[third - 1] == nums[third]) {
                        third --;
                    }
                    second ++;
                    third --;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        result.forEach(System.out::println);
    }
}
