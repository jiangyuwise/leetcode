package q224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author admin
 * @date 2020/9/14 15:41
 */
public class Solution {

    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int sign = 1;
        int num = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                switch (ch) {
                    case '+':
                        result += sign * num;
                        sign = 1;
                        num = 0;
                        break;
                    case '-':
                        result += sign * num;
                        sign = -1;
                        num = 0;
                        break;
                    case '(':
                        stack.push(result); // 存储左算子
                        stack.push(sign); // 存储符号位
                        sign = 1;
                        result = 0;
                        break;
                    case ')':
                        result += sign * num;
                        result *= stack.pop(); // 乘以符号位
                        result += stack.pop(); // 加上左算子
                        num = 0;
                        break;
                }
            }
        }
        return result + sign * num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("1-1"));
    }
}
