package q373_查找最小的K对数字;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/22 14:46
 */
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return new LinkedList<>();
        // 大顶堆
        PriorityQueue<int[]> heap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < nums1.length; i ++) {
            boolean hasUpdate = false;
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                // 本次的和比堆中的数都大，意味着后面的都大，无需继续
                if (heap.size() >= k && sum > heap.peek()[0]) {
                    break;
                }
                hasUpdate = true;
                heap.offer(new int[]{sum, nums1[i], nums2[j]});
                if (heap.size() > k) {
                    heap.poll();
                }
                //System.out.println(heap);
            }
            if (!hasUpdate) break;
        }
        List<List<Integer>> ans = new LinkedList<>();
        while (!heap.isEmpty()) {
            int[] ele = heap.poll();
            List<Integer> list = new LinkedList<>();
            list.add(ele[1]);
            list.add(ele[2]);
            ans.add(0, list);
        }
        return ans;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return new LinkedList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(nums1.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                priorityQueue.add(new int[]{nums1[i] + nums2[j], nums1[i], nums2[j]});
            }
        }
        if ( k < priorityQueue.size()) {
            for (int i = 0; i < k; i++) {
                List<Integer> temp = new ArrayList<>();
                int[] array = priorityQueue.poll();
                temp.add(array[1]);
                temp.add(array[2]);
                list.add(temp);
            }
        }else {
            for (int i = 0; i < priorityQueue.size(); i++) {
                List<Integer> temp = new ArrayList<>();
                int[] array = priorityQueue.poll();
                temp.add(array[1]);
                temp.add(array[2]);
                list.add(temp);
            }
        }

        return list;
    }
}
