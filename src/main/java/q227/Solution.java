package q227;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author admin
 * @date 2020/9/14 14:34
 */
public class Solution {

    public int calculate(String s) {
        s = s.trim();
        Deque<Integer> stack = new LinkedList<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if (!Character.isDigit(ch) || i == s.length() - 1) {
                int left;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        left = stack.pop();
                        stack.push(left * num);
                        break;
                    case '/':
                        left = stack.pop();
                        stack.push(left / num);
                        break;
                }
                sign = ch;
                num = 0;
            }
        }
        int result = 0;
        for (int tmp : stack) {
            result += tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate(" 3/2 "));
    }
}
