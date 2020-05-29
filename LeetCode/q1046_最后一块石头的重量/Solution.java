package q1046_最后一块石头的重量;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/22 15:12
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null) return 0;
        if (stones.length == 1) return stones[0];
        //整个大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //往进放
        for (int v : stones) {
            priorityQueue.add(v);
        }
        //当队列长度大于等于2就可以粉碎
        while (priorityQueue.size() >= 2) {
            int num1 = priorityQueue.poll();
            int num2 = priorityQueue.poll();
            if (num1 == num2) {//完全粉碎
                continue;
            }else {//还剩下的放进去
                priorityQueue.add(num1 - num2);
            }
        }
        if (!priorityQueue.isEmpty()) {//剩一块石头
            return priorityQueue.poll();
        }else {//没有石头剩下
            return 0;
        }
    }
}
