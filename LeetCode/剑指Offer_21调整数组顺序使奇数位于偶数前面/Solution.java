package 剑指Offer_21调整数组顺序使奇数位于偶数前面;

import com.sun.prism.impl.shape.BasicRoundRectRep;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/20 16:05
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if ((nums[left] & 1) == 1) {
                left++;
            } else if ((nums[right] & 1) != 1) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
