package q657_机器人能否返回原点;


/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/28 0:30
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int[] flag = {0, 0};
        for (Character ch : chars) {
            if (ch == 'U') {
                flag[0] += 1;
            }
            if (ch == 'D') {
                flag[0] -= 1;
            }
            if (ch == 'L') {
                flag[1] -= 1;
            }
            if (ch == 'R') {
                flag[1] += 1;
            }
        }
        return flag[0] == 0 && flag[1] == 0;
    }
}
