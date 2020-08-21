package q94;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author admin
 * @date 2020/8/20 22:08
 */
public class Solution {

    public List<Integer> traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive(root, result);
        return result;
    }

    public void recursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null)
            recursive(root.left, result);
        result.add(root.val);
        if (root.right != null)
            recursive(root.right, result);
    }

}


