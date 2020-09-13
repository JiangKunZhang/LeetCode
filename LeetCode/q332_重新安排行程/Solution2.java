package q332_重新安排行程;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/28 0:19
 */
public class Solution2 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        for (List<String> list : tickets) {
            PriorityQueue<String> priorityQueue = map.computeIfAbsent(list.get(0), k -> new PriorityQueue<String>());
            priorityQueue.add(list.get(1));
        }
        dfs(map, res, "JFK");
        return res;
    }

    public void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String start) {
        while (map.containsKey(start) && map.get(start).size() > 0) {
            String next = map.get(start).poll();
            dfs(map, res, next);
        }
        res.add(0, start);
    }
}
