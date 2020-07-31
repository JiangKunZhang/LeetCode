package q389_找不同;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 11:50
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        char res = ' ';
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int val = map.getOrDefault(ch,0);
            if (val > 0) {
                map.put(ch,val-1);
            }else {
                res = ch;
                break;
            }
        }
        return res;
    }
}
