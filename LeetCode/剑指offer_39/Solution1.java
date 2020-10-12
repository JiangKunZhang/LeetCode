package 剑指offer_39;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/7 9:19
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = nums.length / 2;
        int index = partition(nums, left, right);
        while (index != mid) {
            if (index < mid) {
                index = partition(nums, index + 1, right);
            }
            if (index > mid){
                index = partition(nums, left, index - 1);
            }
        }
        return nums[index];
    }

    public static int partition(int[] array, int left, int right) {
        int tmp = array[left];
        while (left < right) {
            while (left < right && array[right] >= tmp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= tmp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        return left;
    }
}
//快排都能超时？？？ a u kidding me
