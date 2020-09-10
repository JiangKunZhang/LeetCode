package q491_递增子序列;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/26 0:09
 */
public class Solution {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        dfs(0, nums, res, cur, set);
        return res;
    }

    public static void dfs(int start, int[] nums, List<List<Integer>> res, List<Integer> cur, Set<List<Integer>> set) {

        if ((cur.size() >= 2) && !set.contains(cur)) {
            res.add(new ArrayList<>(cur));
            set.add(new ArrayList<>(cur));
        }

        for (int i = start; i < nums.length; i++) {
            if (cur.size() == 0 || (cur.get(cur.size() - 1) <= nums[i])) {
                cur.add(nums[i]);
                dfs(i + 1, nums, res, cur, set);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4,3,2,1};
        System.out.println(findSubsequences(array));
    }
}
