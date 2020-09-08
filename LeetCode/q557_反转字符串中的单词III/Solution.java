package q557_反转字符串中的单词III;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/30 9:38
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int start = 0;
        int i = 0;
        while (i < s.length()) {
            start = i;
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            for (int j = start; j < i; j++) {
                sb.append(s.charAt(start + i - 1 - j));
            }
            while (i < s.length() && s.charAt(i) == ' ') {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
