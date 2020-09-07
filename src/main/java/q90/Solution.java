package q90;

import java.util.*;

/**
 * @author admin
 * @date 2020/9/6 13:43
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        for (int i = 0; i <= nums.length; i ++) {
            dfs(result, path, nums, 0, i);
        }
        return result;
    }

    public void dfs(List<List<Integer>> result, Deque<Integer> path, int[] nums, int index, int size) {
        if (path.size() == size) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < nums.length; i ++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            dfs(result, path, nums, i + 1, size);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        result.forEach(System.out::println);
    }
}
