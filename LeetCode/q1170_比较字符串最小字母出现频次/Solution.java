package q1170_比较字符串最小字母出现频次;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 20:18
 */
public class Solution {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int tmp = 0;
        int[] ret = new int[queries.length];
        int[] target = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            target[i] = f(words[i]);
        }
        Arrays.sort(target);//排好序，为二分查找做准备
        for (int i = 0; i < queries.length; i++) {
            ret[i] = binarySearch(f(queries[i]),target);//使用二分查找优化一下
        }
        return ret;
    }

    public static int binarySearch(int target, int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < array[mid]) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        if (array[left] <= target) {
            return 0;
        }else {
            return array.length - left;
        }
    }

    public static int f(String string) {
        if(string == null || string.length() == 0)
            return 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i),map.getOrDefault(string.charAt(i),0) + 1);
        }
        char charMin = string.charAt(0);
        for (int i = 1; i < string.length(); i++) {
            if (charMin > string.charAt(i)) {
                charMin = string.charAt(i);
            }
        }
        return map.get(charMin);

    }

    public static void main(String[] args) {
        String[] queries = {"bbb","cc"};
        String[] words = {"a","aa","aaa","aaaa"};
        int[] ret = numSmallerByFrequency(queries,words);
        System.out.println(Arrays.toString(ret));
    }
}
