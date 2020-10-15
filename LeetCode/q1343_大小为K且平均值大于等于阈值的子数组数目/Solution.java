package q1343_大小为K且平均值大于等于阈值的子数组数目;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/6/18 17:38
 */
public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int res = 0;
        int tar = k * threshold;//平均值 * k
        //把前 k 个先加起来，形成一个窗口
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        //看第一个窗口满足条件吗
        if (sum >= tar) {
            res++;
        }
        //最后一个元素
        int index = k;
        //滑动到数组结束
        for (int i = 0; i < arr.length - k; i++) {
            sum = sum + arr[index] - arr[i];//加后面的，减前面的
            if (sum >= tar) {//比较
                res++;
            }
            index++;//往后滑动
        }
        return res;
    }
}
