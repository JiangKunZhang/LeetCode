package q125_验证回文串;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/19 12:16
 */
public class Solution {
    public static boolean isPalindrome(String s) {
        String string = s.toLowerCase();
        char[] chars = string.toCharArray();
        int i = 0;
        int j = string.length() - 1;
        while (i < j) {
            if ((chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 'a' && chars[i] <= 'z')) {
                if ((chars[j] >= '0' && chars[j] <= '9') || (chars[j] >= 'a' && chars[j] <= 'z')) {
                    if (chars[i] != chars[j]) {
                        return false;
                    }else {
                        i++;
                        j--;
                    }
                }else {
                    j--;
                }
            }else {
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
