package q1260_二维网格迁移;

import java.util.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/13 18:05
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //移动k步
        for (; k > 0; k--) {
            //每次定义新的二维数组数组
            int[][] array = new int[grid.length][grid[0].length];
            //1.元素 grid[i][j] 迁移到 grid[i][j + 1]
            for (int row = 0;row < grid.length; row++) {
                for (int col = 0; col < grid[0].length - 1; col++) {
                    array[row][col + 1] = grid[row][col];
                }
            }
            //2.元素 grid[i][n - 1] 迁移到 grid[i + 1][0]
            for (int row = 0; row < grid.length - 1; row++) {
                array[row + 1][0] = grid[row][grid[0].length-1];
            }
            //3.元素 grid[m - 1][n - 1] 迁移到 grid[0][0]
            array[0][0] = grid[grid.length - 1][grid[0].length - 1];
            //移动一次的结果给grid，下次在这个基础上移动
            grid = array;
        }
        //把二位数组转为二维列表
        List<List<Integer>> ret = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int val : row) {
                rowList.add(val);
            }
            ret.add(rowList);
        }
        return ret;
    }

}
