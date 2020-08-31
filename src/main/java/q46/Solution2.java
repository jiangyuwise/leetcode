package q46;

import java.util.*;

/**
 * @author admin
 * @date 2020/8/31 11:30
 */
public class Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new LinkedList<>();
        dfs(result, path, nums, used);
        return result;
    }

    public void dfs(List<List<Integer>> result ,Deque<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(result, path, nums, used);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        result.forEach(System.out::println);
    }
}
