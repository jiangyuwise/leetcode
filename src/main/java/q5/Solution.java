package q5;

/**
 * 求最长的回文子串
 * babad 输出 bab
 * cbbd 输出 bb
 * 动态规划状态转移方程:
 * 如果一个字符串的头尾两个字符不相等, 则一定不是回文
 * 如果一个字符串的头尾两个字符相等, 则继续判断:
 *      如果里面的子串是回文, 整体就是回文
 *      如果子串不是回文, 整体就不是回文
 * dp[i][j] 表示子串 s[i] 到 s[j] 是否为回文
 * dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
 *
 * 时间 O(n^2), 空间 O(n^2)
 * @author admin
 * @date 2020/5/4 16:08
 */
public class Solution {

    public String sub(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLength = 1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) { // a, aa, aba 形式
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sub("cbbd"));
    }

}
