package q491_递增子序列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/26 0:14
 */
public class Solution2 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, -1, 0, list, result);
        return result;
    }

    private void dfs(int[] nums, int last, int pos, List<Integer> list, List<List<Integer>> result) {
        // 结束条件
        if(pos == nums.length) return;
        // 是否符合要求
        if((list.isEmpty() || list.get(list.size() - 1) <= nums[pos]) && isContains(nums, last, pos)) {
            list.add(nums[pos]);
            if(list.size() >= 2)
                result.add(new ArrayList<>(list));
            dfs(nums, pos, pos + 1, list, result);
            list.remove(list.size() - 1);
        }
        dfs(nums, last, pos + 1, list, result);
    }

    private boolean isContains(int[] nums, int last, int pos) {
        for(int i = last+1; i < pos; i++) {
            if(nums[i] == nums[pos])
                return false;
        }
        return true;
    }
}
