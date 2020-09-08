package q105;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @date 2020/9/7 13:39
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, 0, map);
    }

    public TreeNode build(int[] preorder, int pStart, int pEnd, int iStart, Map<Integer, Integer> map) {
        if (pStart == pEnd) {
            return null;
        }
        int val = preorder[pStart];
        TreeNode root = new TreeNode(val);
        int index = map.get(val); // 根节点索引
        int left = index - iStart + 1; // 左边节点个数
        root.left = build(preorder, pStart + 1, pStart + left, iStart, map);
        root.right = build(preorder, pStart + left, pEnd, index + 1, map);
        return root;
    }
}
