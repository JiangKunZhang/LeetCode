package q525_连续数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 12:51
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int count = 0;
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else count--;
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen,i-map.get(count));
            }else {
                map.put(count,i);
            }
        }
        return maxLen;
    }
}
