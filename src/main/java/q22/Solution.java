package q22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2020/8/27 22:22
 */
public class Solution {

    public List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs(result, "", n, n);
        return result;
    }

    public void dfs(List<String> strings, String curString, int left, int right) {
        if (left == 0 && right == 0) {
            strings.add(curString);
            return;
        }
        // 剪枝
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(strings, curString + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(strings, curString + ")", left, right - 1);
        }
    }
}
