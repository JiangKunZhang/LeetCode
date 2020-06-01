package q3_无重复字符的最长字串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 15:57
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int fast = 0;
        int slow = 0;
        for (fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            if (map.containsKey(ch)) {
                slow = Math.max(slow,map.get(ch) + 1);//slow往后走
            }
            map.put(ch,fast);//存在的话还得更新fast
            max = Math.max(max,fast - slow + 1);

        }
        return max;
    }

    public static void main(String[] args) {
        int len = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(len);
    }
}
