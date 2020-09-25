package q106;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @date 2020/9/25 09:35
 */
public class Solution {
    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return build(0, inorder.length - 1);
    }

    public TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        int val = postorder[postIndex];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);
        postIndex --;
        root.right = build(index + 1, end);
        root.left = build(start, index - 1);
        return root;
    }
}
