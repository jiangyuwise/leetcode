package q402;

import java.util.LinkedList;

/**
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 栈 + 贪心算法
 *
 * 如果右边的数字小于左边的数字, 则删除左边的数字
 * 使用栈存储数字, 如果数字小于栈顶(左边的数字), 则弹出栈顶
 * @author admin
 * @date 2020/8/20 14:33
 */
public class Solution {

    public String removeKDigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char ch : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > ch) {
                stack.removeLast();
                k--;
            }
            stack.addLast(ch);
        }
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }

        StringBuilder builder = new StringBuilder();
        boolean leadZero = true;
        for (char ch : stack) {
            if (ch == '0' && leadZero) {
                continue;
            }
            leadZero = false;
            builder.append(ch);
        }
        if (builder.length() == 0) {
            return "0";
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeKDigits("1432219", 3));
    }
}
