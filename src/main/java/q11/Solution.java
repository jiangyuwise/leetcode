package q11;

/**
 * 给定一个数组, 数组的下标表示每个点的 x, 值表示 y.
 * 选取 2 个点, 与 x 轴构成的矩形面积最大
 * @author admin
 * @date 2020/8/20 15:39
 */
public class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0, tmp;
        while (left < right) {
            tmp = Math.min(height[left], height[right]) * (right - left);
            if (result < tmp) {
                result = tmp;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(nums));
    }
}
