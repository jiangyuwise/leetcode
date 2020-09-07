package q84;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author admin
 * @date 2020/9/6 10:26
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;

        int[] newHeights = new int[length + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, length);
        newHeights[length + 1] = 0;
        length += 2;

        int maxArea = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(0);

        for (int i = 1; i < length; i ++) {
            while (newHeights[i] < newHeights[stack.peekLast()]) {
                int height = newHeights[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.addLast(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
         int[] heights = {2, 1, 5, 6, 2, 3};
//        int[] heights = {1, 1};
        Solution solution = new Solution();
        int res = solution.largestRectangleArea(heights);
        System.out.println(res);
    }
}
