/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:01
 * @Description
 * @Version 1.0
 **/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        String[] words = str.split(" ");

        if (patterns.length != words.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>(100);
        for (int i = 0; i < patterns.length; i++) {
            if (map.size() != 0) {
                if (map.containsKey(patterns[i]) && !map.get(patterns[i]).equals(words[i])) {
                    return false;
                }
            }
            map.put(patterns[i], words[i]);
        }

        Set<String> set = new HashSet<>(map.values());

        return set.size() == map.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String pattern1 = "aaaa";
        String str1 = "dog cat cat dog";
        System.out.println(s.wordPattern(pattern1, str1));
    }
}
