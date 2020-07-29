package q219_存在重复元素II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 13:08
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //不存在就放进来
            if (!map.containsKey(nums[i])) {
                map.put(nums[i],i);
            }else {//存在看看位置
                int index = map.get(nums[i]);
                if (Math.abs(index - i) <= k) {//如果小于就可以返回了
                    return true;
                }else {//不小于记得更新，万一后面还有
                    map.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
