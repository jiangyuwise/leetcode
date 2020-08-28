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
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k --;
                } else if (sum < 0) {
                    j ++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while (j < k && nums[j] == nums[j + 1]) {
                        j ++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        k --;
                    }
                    j ++;
                    k --;
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
