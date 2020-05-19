package q680_验证回文字符串II;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/19 13:52
 *
 * 如果两个指针指向的字符不同，则两个字符中必须有一个被删除，
 * 此时我们就分成两种情况：即删除左指针对应的字符
 * 或者删除右指针对应的字符，留下子串
 * 当这两个子串中至少有一个是回文串时，就说明原始字符串删除一个字符之后就以成为回文串。
 */
public class Solution {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                boolean flag1 = true, flag2 = true;
                for (int left = i, right = j - 1; left < right; left++,right--) {
                    if (chars[left] != chars[right]) {
                        flag1 = false;
                        break;
                    }
                }
                for (int left = i + 1, right = j; left < right; left++,right--) {
                    if (chars[left] != chars[right]) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }
}
