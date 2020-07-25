package q575_分糖果;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/6/12 14:57
 *
 * 既然平均分，那么就是分总数的一半，
 * 那么如果我的种类数多于一半了，肯定就要返回总数的一半，
 * 如果不多余，则返回种类数给妹妹。
 */
public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) {
            set.add(i);
        }
        return Math.min(candies.length / 2, set.size());
    }
}
