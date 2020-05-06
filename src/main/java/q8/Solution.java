package q8;

/**
 * 字符串转数字
 * @author admin
 * @date 2020/5/5 16:44
 */
public class Solution {

    public int atoi(String str) {
        str = str.trim();
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        int signal = 1;
        char[] chars = str.toCharArray();
        int i = 0;
        if (chars[i] == '-') {
            signal = -1;
            i++;
        } else if (chars[i] == '+') {
            i++;
        } else if (!Character.isDigit(chars[i])) {
            return 0;
        }
        int result = 0;
        while (i < length && Character.isDigit(chars[i])) {
            char ch = chars[i];
            int tmp = ch - '0';
            if (result > (Integer.MAX_VALUE - tmp) / 10) {
                return signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + tmp;
            i++;
        }
        return result * signal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.atoi("   -42"));
    }
}
