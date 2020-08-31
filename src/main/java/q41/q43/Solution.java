package q41.q43;

/**
 * @author admin
 * @date 2020/8/31 00:05
 */
public class Solution {
    public String multiply(String num1, String num2) {
        String result = "0";
        if(num1.equals("0") || num2.equals("0")) {
            return result;
        }
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i --) {
            int incr = 0;
            StringBuilder builder = new StringBuilder();
            // 除最后一位, 每个都要补 0
            for (int j =  n - 1; j > i; j --) {
                builder.append(0);
            }
            int y = num2.charAt(i) - '0';

            for (int j = m - 1; j >= 0; j --) {
                int x = num1.charAt(j) - '0';
                int tmp = x * y + incr;
                builder.append(tmp % 10);
                incr = tmp / 10;
            }
            if (incr != 0) {
                builder.append(incr);
            }
            result = add(result, builder.reverse().toString());
        }
        return result;
    }

    public String add(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int incr = 0;
        while (i >= 0 || j >= 0 || incr != 0) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int tmp = x + y + incr;
            builder.append(tmp % 10);
            incr = tmp / 10;
            i --;
            j --;
        }
        return builder.reverse().toString();
    }
}
