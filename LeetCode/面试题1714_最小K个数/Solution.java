package 面试题1714_最小K个数;

import java.util.PriorityQueue;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/22 14:11
 */
public class Solution {
    public int[] smallestK(int[] arr, int k) {
        //参数检测
        if (arr == null || k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length);
        //把数组中的元素放入堆中
        for (int v : arr) {
            priorityQueue.add(v);
        }
        //取出优先队列的前k个元素放入数组
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }
}
