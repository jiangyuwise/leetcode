package q72;

/**
 * 给定两个单词 word1 和 word2, 计算出将 word1 转换为 word2 所使用的最少操作数.
 * 操作包括 插入, 删除, 替换
 *
 * 假设:
 * 字符串 word1 的长度为 i, 字符串 word2 的长度为 j, 将 word1 转换为 word2 所使用的最少操作数为 dp[i][j]
 *
 * 分情况判断:
 * 如果 word1 与 word2 相等, 则不需要操作, dp[i][j] = dp[i-1][j]
 *
 * 1) 如果把字符 word1[i] 替换成与 word2[j] 相等, 则有 dp[i][j] = dp[i-1][j-1] + 1
 * 2) 如果在字符串 word1 末尾插入与 word2[j] 相等的字符, 则有 dp[i][j] = dp[i][j-1] + 1
 * 3) 如果把字符串 word1[i] 删除, 则有 dp[i][j] = dp[i-1][j] + 1
 * dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
 *
 * 初始值, 如果某一个字符串的长度为 0, 则另一个字符串只能进行插入或者删除操作了.
 * @author admin
 * @date 2020/5/15 22:31
 */
public class Solution {

    public int edit(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.edit("horse", "ros"));
    }

}
