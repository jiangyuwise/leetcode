package q20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author admin
 * @date 2020/8/27 21:31
 */
public class Solution {

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }


}
