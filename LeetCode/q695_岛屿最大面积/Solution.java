package q695_岛屿最大面积;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/5 16:28
 */
public class Solution {
    int[][] position = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int sum = dfs(grid, row, col, i, j);
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col, int curX, int curY) {
        int sum = 1;
        grid[curX][curY] = 0;
        for (int i = 0; i < 4; i++) {
            int newX = curX + position[i][0];
            int newY = curY + position[i][1];
            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }
            if (grid[newX][newY] == 1) {
                sum += dfs(grid, row, col, newX, newY);
            }
        }
        return sum;
    }
}
