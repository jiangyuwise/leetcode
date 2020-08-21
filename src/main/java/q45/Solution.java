package q45;

/** 跳跃游戏, 数组的每个数字表示可以跳的最长距离, 请使用最少的跳跃次数到达数组的最后一个位置.
 * 输入: [2, 3, 1, 1, 4]
 * 输出: 2
 *  0 -> 2(跳 1 步) -> 3(跳 3 步) -> 4.
 *
 *  贪心算法, 找到每个格子上能跳到的最远距离.
 * @author admin
 * @date 2020/8/21 15:20
 */
public class Solution {

    public int jump(int[] nums) {
        int end = 0; // 表示当前能跳的边界
        int maxDistance = 0; // 当前位置能跳到的最远距离.
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (i == end) { // 已经跳到最远处了, 步数加 1
                end = maxDistance;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 1, 2, 1, 3, 5};
        System.out.println(solution.jump(nums));
    }
}
