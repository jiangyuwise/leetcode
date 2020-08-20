package q287;

import java.util.BitSet;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * @author admin
 * @date 2020/8/20 15:18
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        BitSet bitSet = new BitSet(nums.length);
        int duplicate = 0;
        for (int num : nums) {
            if (bitSet.get(num)) {
                duplicate = num;
                break;
            }
            bitSet.set(num);
        }
        return duplicate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(solution.findDuplicate(nums));
    }
}
