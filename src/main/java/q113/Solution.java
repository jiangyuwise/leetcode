package q113;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author admin
 * @date 2020/9/8 12:17
 */
public class Solution {

    public int sum = 0;

    public int sumNumbers(TreeNode root) {
        Deque<Integer> path = new LinkedList<>();
        dfs(path, root);
        return sum;
    }

    public void dfs(Deque<Integer> path, TreeNode node) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            int tmp = 0;
            for (int num : path) {
                tmp = tmp * 10 + num;
            }
            sum += tmp;
        }
        dfs(path, node.left);
        dfs(path, node.right);
        path.removeLast();
    }
}
