package q46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author admin
 * @date 2020/8/31 10:31
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> items = new ArrayList<>();
        for (int num : nums) {
            items.add(num);
        }
        dfs(result, items,  0);
        return result;
    }

    public void dfs(List<List<Integer>> result, ArrayList<Integer> items, int index) {
        if (index == items.size()) {
            result.add(new ArrayList<>(items));
        }
        for (int i = index; i < items.size(); i ++) {
            Collections.swap(items, index, i);
            dfs(result, items, index +1);
            Collections.swap(items, index, i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        result.forEach(System.out::println);
    }
}
