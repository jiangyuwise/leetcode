package q56;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author admin
 * @date 2020/8/31 17:04
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Deque<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            if (result.isEmpty() || result.peek()[1] < start) {
                result.add(new int[]{start, end});
            } else {
                result.getLast()[1] = Math.max(result.peek()[1], end);
            }
        }
        return result.toArray(new int[][] {});
    }
}
