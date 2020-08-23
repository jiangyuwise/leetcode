package q4;

import java.util.PriorityQueue;

/**
 * 使用最大堆, 找出中间的元素.
 * queue.offer 时间复杂度为 O(log n)
 *
 * O(m + n), 失败.
 * @author admin
 * @date 2020/8/22 00:16
 */
public class Solution2 {

    public double find(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(total);
        for (int num : nums1) {
            queue.offer(num);
        }
        for (int num : nums2) {
            queue.offer(num);
        }
        double result;
        int mid = total / 2;
        if (total % 2 == 1) {
            for (int i = 0; i < mid; i++) {
                queue.poll();
            }
            result = queue.poll();
        } else {
            for (int i = 0; i < mid - 1; i++) {
                queue.poll();
            }
            result = queue.poll();
            result += queue.poll();
            result /= 2.0;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(solution.middle(nums1, nums2));
    }
}
