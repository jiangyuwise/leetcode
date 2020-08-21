package q96;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * dp[i] 表示 以 i 为根的二叉树的个数. 左边的节点为 1... i -1, 右边的节点数为 i + 1... n
 * dp[0] = 1, dp[1] = 1
 * @author admin
 * @date 2020/8/21 10:38
 */
public class Solution {

    public int tree(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tree(3));
    }


}
