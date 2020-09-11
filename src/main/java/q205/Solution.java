package q205;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 * @date 2020/9/11 11:41
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        return check(s, t) && check(t, s);
    }

    public boolean check(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }
}
