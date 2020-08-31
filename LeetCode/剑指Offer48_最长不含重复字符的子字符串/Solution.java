package 剑指Offer48_最长不含重复字符的子字符串;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 19:02
 */
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int fast = 0;
        int slow = 0;
        int max = 0;
        for (fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            if (map.containsKey(ch)) {
                slow = Math.max(slow, map.get(ch) + 1);
            }
            map.put(ch, fast);
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}