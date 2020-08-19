package q692_前k个高频单词;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/28 23:16
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String string : words) {
            map.put(string,map.getOrDefault(string,0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //如果相等 按字典序 （compareTo） 不相等 从大到小
                return map.get(o1) == map.get(o2) ? o1.compareTo(o2) : map.get(o2) - map.get(o1);
            }
        });
        return list.subList(0,k);
    }
}
