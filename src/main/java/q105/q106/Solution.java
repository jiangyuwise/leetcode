package q105.q106;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @date 2020/9/7 14:24
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length, inorder.length, map);
    }

    public TreeNode build(int[] postorder, int pStart, int pEnd, int iEnd, Map<Integer, Integer> map) {
        if (pStart == pEnd) {
            return null;
        }
        int val = postorder[pEnd - 1];
        TreeNode root = new TreeNode(val);

        int index = map.get(val);
        int right = iEnd - index - 1; // 右边的节点数
        root.left = build(postorder, pStart, pEnd - right - 1, index, map);
        root.right = build(postorder, pEnd - right - 1, pEnd - 1, iEnd, map);
        return root;
    }
}
