package 剑指offer_39;

import java.util.HashMap;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/7 9:39
 */
public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }
}
