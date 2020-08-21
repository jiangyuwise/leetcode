package q26;

/**
 * 给一个排好序的数组, 去除重复的元素, 去重后的元素个数
 * @author admin
 * @date 2020/8/21 14:36
 */
public class Solution {

    public int clean(int[] nums) {
        int i = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
