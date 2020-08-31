package q56.q57;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author admin
 * @date 2020/8/31 17:26
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int i = 0, length = intervals.length;
        Deque<int[]> result = new LinkedList<>();
        // 先把比 newInterval 小的区间放进去
        while (i < length && intervals[i][0] < newStart) {
            result.add(intervals[i ++]);
        }
        if (result.isEmpty() || result.peekLast()[1] < newStart) {
            result.add(newInterval); // 没有重叠
        } else { // 发生重叠
            result.getLast()[1] = Math.max(result.peekLast()[1], newEnd);
        }

        while (i < length) {
            int[] interval = intervals[i++];
            int start = interval[0], end = interval[1];
            if (result.peekLast()[1] < start) { // 没有冲突
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.peekLast()[1], end);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

}
