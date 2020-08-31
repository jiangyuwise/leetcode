package q39;

import java.util.*;

/**
 * @author admin
 * @date 2020/8/30 17:51
 */
public class Solution {

    public List<List<Integer>> sum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new LinkedList<>(), candidates, target, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, Deque<Integer> path, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfs(result, path, candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }

}
