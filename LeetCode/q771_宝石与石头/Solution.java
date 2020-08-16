package q771_宝石与石头;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/28 19:07
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
