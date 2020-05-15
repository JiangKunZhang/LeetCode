package q997_找到小镇的法官;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/13 16:47
 */
public class Solution {
    public int findJudge(int N, int[][] trust) {
        //法官是这样一个点：出度为0，并且入度为N-1
        int[] in = new int[N+1];
        int[] out = new int[N+1];
        for (int[] path : trust) {
            int start = path[0];
            int end = path[1];
            in[end]++;
            out[start]++;
        }
        for (int i = 1; i <= N; i++) {
            if (in[i] == 0 && out[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
