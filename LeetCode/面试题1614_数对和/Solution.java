package 面试题1614_数对和;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/6/12 15:17
 */
class Solution {
    public static List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> lists = new LinkedList<>();
        for (int i : nums) {
            int tmp = target - i;
            if (map.get(tmp) != null) {
                List<Integer> list = new LinkedList<>();
                list.add(i);
                list.add(tmp);
                lists.add(list);
                if (map.get(tmp) == 1) map.remove(tmp);
                else map.put(tmp,map.get(tmp) - 1);
            }else {
                map.put(i,map.getOrDefault(i,0) + 1);
                //如果没有 tmp 就把 i 放进来，防止后面用
                //如果有 tmp 就不放 i ，同时 tmp 还要减 1
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        int[] array = {5,6,5};
        List<List<Integer>> lists = new LinkedList<>();
        lists = pairSums(array,11);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
