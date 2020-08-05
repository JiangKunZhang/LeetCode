package q819_最常见的单词;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 21:35
 */
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += '.';
        Set<String> set = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        for (String s : banned) {
            set.add(s);
        }
        char[] chars = paragraph.toLowerCase().toCharArray();
        StringBuffer word = new StringBuffer();;
        int max = 0;
        String res = "";
        for (char c : chars) {
            if (Character.isLetter(c)) {
                word.append(c);
            }else if (word.length() > 0){
                String s = word.toString();
                if (!set.contains(s)) {
                    map.put(s,map.getOrDefault(s,0) + 1);
                    if (map.get(s) > max) {
                        res = s;
                        max = map.get(s);
                    }
                }
                word = new StringBuffer();
            }
        }
        return res;
    }
}
