package q186;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author admin
 * @date 2020/9/9 17:46
 */
public class Solution {


    public void reverseWords(char[] s) {
        String str = new String(s);
        List<String> list = Arrays.asList(str.split("\\s"));
        Collections.reverse(list);
        String reversedStr = String.join(" ", list);
        char[] chars = reversedStr.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
                s[i] = chars[i];
        }
    }
}
