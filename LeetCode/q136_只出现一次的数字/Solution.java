package q136_只出现一次的数字;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/15 0:04
 */
public class Solution {
    public int singleNumber(int[] nums) {
        //异或 重复的就抵消
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret = ret ^ nums[i];
        }
        return ret;
    }
}
