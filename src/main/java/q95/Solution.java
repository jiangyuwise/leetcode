package q95;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定数字 n, 使用 1 ~ n 生成二叉树
 * 求出所有的二叉树
 *
 * 选取一个节点 i, 作为根节点, 把[1 ~ i - 1] 生成不同的左子树, 把 [i + 1 ~ n] 生成不同的右子树,
 * 最后不同的左右子树组合在一起, 即可得到完整的树.
 * @author admin
 * @date 2020/8/24 11:03
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return recursive(1, n);
    }

    public List<TreeNode> recursive(int start, int end) {
        List<TreeNode> trees = new LinkedList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = recursive(start, i - 1);
            List<TreeNode> rightTrees = recursive(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode tree = new TreeNode(i);
                    tree.left = left;
                    tree.right = right;
                    trees.add(tree);
                }
            }
        }
        return trees;
    }


}
