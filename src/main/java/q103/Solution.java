package q103;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树, 按层先法遍历, 要求先从左往右，再从右往左进行下一层遍历
 * @author admin
 * @date 2020/8/20 20:23
 */
public class Solution {
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> item = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if ((level & 1) == 0)
                    item.push(node.val);
                else
                    item.add(node.val);
            }
            result.add(item);
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] data = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.treeify(data);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.traverse(root);
        result.forEach(System.out::println);
    }
}