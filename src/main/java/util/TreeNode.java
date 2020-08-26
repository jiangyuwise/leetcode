package util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author admin
 * @date 2020/8/20 22:12
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode treeify(Integer[] data) {
        if (data.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(data[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;
        for (int i = 1; i < data.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (data[i] != null) {
                    node.left = new TreeNode(data[i]);
                    queue.offer(node.left);
                    isLeft = false;
                }
            } else {
                if (data[i] != null) {
                    node.right = new TreeNode(data[i]);
                    queue.offer(node.right);
                    queue.poll();
                    isLeft = true;
                }
            }
        }
        return root;
    }
}