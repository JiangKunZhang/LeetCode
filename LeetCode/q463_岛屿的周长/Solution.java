package q463_岛屿的周长;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/6/12 18:17
 */
public class Solution {
    public static int islandPerimeter(int[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cnt = 0;
                if (grid[i][j] == 1) {
                    if (i-1 >= 0 && grid[i-1][j] == 1) {
                        cnt++;
                    }
                    if (i+1 < grid.length && grid[i+1][j] == 1) {
                        cnt++;
                    }
                    if (j-1 >= 0 && grid[i][j-1] == 1) {
                        cnt++;
                    }
                    if (j+1 < grid[i].length && grid[i][j+1] == 1) {
                        cnt++;
                    }
                    ret += 4;
                    ret -= cnt;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] array = {{1,0}};
        int ret = islandPerimeter(array);
        System.out.println(ret);
    }
}
