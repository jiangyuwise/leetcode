package q3;

import java.util.HashSet;
import java.util.Set;

/**
 * 求不含重复字符的最长子串的长度
 * 例如: "abcabcbb" 的最长不重复子串为 "abc", 长度为 3
 * 子串必须是连续的.
 * @author admin
 * @date 2020/1/12 11:44
 */
public class Solution {

    public int length(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int length = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                if (j - i > length) {
                    length = j - i;
                }
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.length(" "));
    }
}
