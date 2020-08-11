package q350_两个数组的交集II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/29 11:33
 *
 * 我们先在 HashMap 记录一个数组中的存在的数字和对应出现的次数。然后，我们遍历第二个数组，检查数字在 HashMap 中是否存在，如果存在且计数为正，则将该数字添加到答案并减少 HashMap 中的计数。
 *
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //哈希数组小的那一个数组，减少内存的使用
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        //计数
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            //个数大于零才放进数组，并且次数减一
            if (map.getOrDefault(num,0) > 0) {
                res[index++] = num;
                map.put(num,map.get(num) - 1);
            }
        }
        //返回数组
        return Arrays.copyOf(res,index);
    }
}
