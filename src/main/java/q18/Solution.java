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
        for (int i = 0; i < length - 3; i ++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j ++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int k = j + 1, m = length - 1;
                while (k < m) {
                    int tmp = nums[i] + nums[j] + nums[k] + nums[m];
                    if (tmp > target) {
                        m --;
                    } else if (tmp < target) {
                        k ++;
                    } else {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        item.add(nums[m]);
                        result.add(item);
                        while (k < m && nums[k] == nums[k + 1] ) {
                            k ++;
                        }
                        while (k < m && nums[m - 1] == nums[m]) {
                            m --;
                        }
                        k ++;
                        m --;
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
