package q5;

/**
 * @author admin
 * @date 2020/9/21 22:47
 */
public class Solution2 {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLength = 1, start = 0;
        for (int i = 0; i < length; i ++) {
            int l = expand(s, i, i);
            int r = expand(s, i, i + 1);
            int tmp = Math.max(l, r);
            if (maxLength < tmp) {
                maxLength = tmp;
                start = i - (maxLength - 1) / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    public int expand(String s, int left, int right) {
        int length = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            length = right - left + 1;
            left --;
            right ++;
        }
        return length;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
