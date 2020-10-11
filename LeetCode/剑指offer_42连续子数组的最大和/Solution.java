package 剑指offer_42连续子数组的最大和;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/17 15:25
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 说明上一次结果为增益
            if (sum > 0) {
                sum += nums[i];
            }
            // 说明上一次结果为减益
            else {
                sum = nums[i];
            }
            ret = Math.max(ret, sum);
        }
        return ret;
    }

    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //前一个位置大于 0 ,说明有增益，就是当前位置加上之前的 array[i - 1] ,
            // 否则就不加 , 加 0 还是 array[i]
            //这里的 array[i] 就是上个解法的 sum
            nums[i] += Math.max(nums[i - 1], 0);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}
