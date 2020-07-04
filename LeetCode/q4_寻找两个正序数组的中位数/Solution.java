package q4_寻找两个正序数组的中位数;

import java.util.Arrays;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/6/12 16:22
 */
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length+nums2.length];
        int i = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int s1 = 0;
        int s2 = 0;
        while (s1 < nums1.length && s2 < nums2.length) {
            if (nums1[s1] <= nums2[s2]) {
                array[i++] = nums1[s1++];
            }else {
                array[i++] = nums2[s2++];
            }
        }
        while (s1 <= nums1.length - 1) {
            array[i++] = nums1[s1++];
        }
        while (s2 <= nums2.length - 1) {
            array[i++] = nums2[s2++];
        }
        int index = (array.length - 1) / 2;
        double res = 0;
        if (array.length % 2 == 1) {
            res = array[index];
        }else {
            res = (array[index] + array[index + 1]) * 1.0 / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] num2 = {2};
        double res = findMedianSortedArrays(num1,num2);
        System.out.println(res);
    }
}
