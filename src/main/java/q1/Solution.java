package q1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @date 2020/5/4 15:03
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < length; i ++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < length; i ++) {
            int rest = target - nums[i];
            if (map.containsKey(rest) && map.get(rest) != i) {
                result[0] = i;
                result[1] = map.get(rest);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 2, 4};
        int target = 6;
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
