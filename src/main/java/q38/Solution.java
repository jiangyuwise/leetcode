package q38;

/**
 * @author admin
 * @date 2020/8/28 22:43
 */
public class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        int count = 1;
        String pre = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pre.length(); i++) {
            if (i < pre.length() - 1 && pre.charAt(i) == pre.charAt(i + 1)) {
                count++;
            } else {
                builder.append(count).append(pre.charAt(i));
                count = 1;
            }
        }
        return builder.toString();
    }
}
