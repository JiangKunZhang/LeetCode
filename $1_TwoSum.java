import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/3/30 21:37
 * 1.两数之和
 */
public class $1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        int[] res=new int[2];
        for(int i = 0, len = nums.length; len > i; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
}
