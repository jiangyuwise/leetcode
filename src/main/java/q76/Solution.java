package q76;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author admin
 * @date 2020/9/3 20:45
 */
public class Solution {

    Map<Character, Integer> oldCount = new HashMap<>();
    Map<Character, Integer> newCount = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLength = t.length();
        for (int i = 0; i < tLength; i++) {
            char ch = t.charAt(i);
            int count = oldCount.getOrDefault(ch, 0);
            oldCount.put(ch, count + 1);
        }
        int minLength = Integer.MAX_VALUE, left = -1, right = -1;
        int sLength = s.length(), l = 0, r = -1;;
        char ch;
        while (r < sLength) {
            r++;
            if (r < sLength) {
                ch = s.charAt(r);
                if (oldCount.containsKey(ch)) {
                    int count = newCount.getOrDefault(ch, 0);
                    newCount.put(ch, count + 1);
                }
            }
            while (check() && l <= r) {
                if (minLength > r - l + 1) {
                    minLength = r - l + 1;
                    left = l;
                    right = l + minLength;
                }
                ch = s.charAt(l);
                if (oldCount.containsKey(ch)) {
                    int count = newCount.getOrDefault(ch, 0);
                    newCount.put(ch, count - 1);
                }
                ++l;
            }
        }
        return left == -1 ? "" : s.substring(left, right);
    }

    public boolean check() {
        for (Entry<Character, Integer> entry : oldCount.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (newCount.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a", t = "a";
        System.out.println(solution.minWindow(s, t));
    }
}
