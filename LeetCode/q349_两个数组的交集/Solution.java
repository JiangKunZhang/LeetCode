package q349_两个数组的交集;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/29 10:04
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set1.add(nums2[i]);
        }
        int len = set.size() > set1.size() ? set1.size() : set.size();
        int[] array = new int[len];
        int index = 0;
        if (set.size() > set1.size()) {
            for (Integer num : set1) {
                if (set.contains(num)) {
                    array[index++] = new Integer(num);
                }
            }

        }else {
            for (Integer num : set) {
                if (set1.contains(num)) {
                    array[index++] = new Integer(num);
                }
            }
        }


        return Arrays.copyOf(array,index);
    }
}
