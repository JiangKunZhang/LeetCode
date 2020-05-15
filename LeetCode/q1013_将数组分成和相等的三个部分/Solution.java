package q1013_将数组分成和相等的三个部分;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/13 17:13
 */
public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int s= 0;
        int count = 0;
        for (int i : A) {
            s += i;
            if (s == sum / 3) {
                count++;
                s = 0;
            }
        }
        //按理说总和为 sum ，算sum / 3 的次数，普通情况肯定为3。
        // 超过3次的情况，超过部分sum必定为0。超过部分的0，可以都归入前面那个堆中
        return count >= 3;
    }
}
