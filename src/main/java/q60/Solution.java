package q60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2020/8/31 19:03
 */
public class Solution {

    public String getPermutation(int n, int k) {
        int[] factor = new int[n]; // 1 ~ k 的阶乘
        k = k - 1; // 第 k 个数在 k - 1 索引上
        factor[0] = 1;
        for (int i = 1; i < n; i ++) {
            factor[i] = factor[i - 1] * i;
        }

        // nums 每使用过一个数, 就删除掉
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            nums.add(i + 1);
        }

        StringBuilder builder = new StringBuilder();

        // i 表示 nums 剩余个数, 初始化为 n - 1
        for (int i = n - 1; i >= 0; i --) {
            int index = k / factor[i];
            builder.append(nums.remove(index));
            k -= index * factor[i];
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));
    }
}
