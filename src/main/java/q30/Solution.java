package q30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2020/8/28 15:47
 */
public class Solution {

    public List<Integer> sub(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordNumber = words.length;
        if (wordNumber == 0) {
            return result;
        }

        int wordLength = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            int count = wordMap.getOrDefault(word, 0);
            wordMap.put(word, count + 1);
        }

        // 每次取固定长度的字符, 如 9 个字符(3 个单词), 逐步移动 i
        for (int i = 0; i < s.length() - wordNumber * wordLength + 1; i++) {
            Map<String, Integer> wordCount = new HashMap<>();
            int num = 0;
            while (num < wordNumber) {
                String word = s.substring(i + num * wordLength, i + (num + 1) * wordLength);
                if (wordMap.containsKey(word)) {
                    int count = wordCount.getOrDefault(word, 0);
                    wordCount.put(word, count + 1);
                    if (wordCount.get(word) > wordMap.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num ++;
            }
            if (num == wordNumber) {
                result.add(i);
            }
        }
        return result;
    }
}
