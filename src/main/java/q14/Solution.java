package q14;

/**
 * @author admin
 * @date 2020/7/24 12:09
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (String str : strs) {
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    break;
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

}
