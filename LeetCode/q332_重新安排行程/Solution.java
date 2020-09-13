package q332_重新安排行程;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/27 23:58
 */
public class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> list : tickets) {
            String src = list.get(0);
            String dest = list.get(1);
            if (!map.containsKey(src)) {
                //放入优先队列，先看字典序小的地方
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dest);
        }
        dfs("JFK");
        //Collections.reverse(res);
        return res;
    }

    public void dfs(String start) {
        while (map.containsKey(start) && map.get(start).size() > 0) {
            String next = map.get(start).poll();
            dfs(next);
        }
        //res.add(start);
        //头插法，就不用重新逆序了，最先进入递归的，最后出来，头插得到正常顺序
        res.add(0, start);
    }
}
