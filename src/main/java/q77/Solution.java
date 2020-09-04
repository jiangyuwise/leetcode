package q77;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author admin
 * @date 2020/9/4 14:11
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new LinkedList<>(), 1, n, k);
        return result;
    }

    public void dfs(List<List<Integer>> result, Deque<Integer> path, int index, int n, int k) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < n + 1; i ++) {
            path.addLast(i);
            dfs(result, path, i + 1, n, k);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(4, 2);
        result.forEach(System.out::println);
    }


}
