package q6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 使用多个 StringBuilder, 时间复杂度为 O(n)
 * @author admin
 * @date 2020/8/27 09:22
 */
public class Solution2 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> builders = new ArrayList<>();
        for (int i = 0; i < numRows; i ++) {
            builders.add(new StringBuilder());
        }
        int y = 0, vy = 1;
        for (char ch : s.toCharArray()) {
            builders.get(y).append(ch);
            if (y + vy == numRows || y + vy == -1) {
                vy = -vy;
            }
            y += vy;
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder tmp : builders) {
            builder.append(tmp.toString());
        }
        return builder.toString();
    }
}
