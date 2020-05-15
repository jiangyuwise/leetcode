package q9;

/**
 * 判断整数是不是回文
 * @author admin
 * @date 2020/5/15 20:57
 */
public class Solution {

    //数组长度为 2, 元素下标 0, 1, 半长 = 1
    //数组长度为 3, 元素下标 0, 1, 2, 半长 = 1

    public boolean is(int x) {
        String str = String.valueOf(x);
        int length = str.length();
        int half = length / 2;
        for (int i = 0; i < half; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.is(121));
    }

}
