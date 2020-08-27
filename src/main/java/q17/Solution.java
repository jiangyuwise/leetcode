package q17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2020/8/27 17:06
 */
public class Solution {
    Map<Character, String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        dfs(result, digits, 0, new StringBuilder());
        return result;
    }

    public void dfs(List<String> strings, String digits, int index, StringBuilder builder) {
        if (index == digits.length()) {
            strings.add(builder.toString());
        } else {
            char digit = digits.charAt(index);
            String letter = map.get(digit);
            int letterLength = letter.length();
            for (int i = 0; i < letterLength; i++) {
                builder.append(letter.charAt(i));
                dfs(strings, digits, index + 1, builder);
                builder.deleteCharAt(index);
            }
        }
    }
}
