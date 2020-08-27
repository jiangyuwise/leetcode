package q7;

/**
 * 数字反转
 * @author admin
 * @date 2020/1/14 12:11
 */
public class Solution {

    private int reverse(int x) {
        int num = 0;
        int tmp = 0;
        while (x != 0) {
            tmp = x % 10;
            x = x / 10;
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && tmp > 7)) {
                return 0;
            }
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && tmp < -8)) {
                return 0;
            }
            num = num * 10 + tmp;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
    }
}
