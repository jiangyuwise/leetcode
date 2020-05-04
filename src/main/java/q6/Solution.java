package q6;

/**
 * 求最长的回文子串
 * @author admin
 * @date 2020/5/4 16:08
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sub("cbbd"));
    }

    public String sub(String s) {
        if (s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = center(s, i, i);
            int length2 = center(s, i, i + 1);
            int length = Math.max(length1, length2);
            if (length > end - start) {
                start = i - (length -1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int center(String s, int left, int right) {
        int i = left, j = right;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
