package q933_最近的请求次数;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/16 0:50
 */
public class RecentCounter {
    public Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        //保证每次对 ping 的调用都使用比之前更大的 t 值
        //所以这是单调队列，弹出不小于 t-3000 的以后，就没有更小的了
        while (!queue.isEmpty() && queue.peek() < t - 3000) {// [t-3000, t] 等于 t-3000 的不出队列
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
