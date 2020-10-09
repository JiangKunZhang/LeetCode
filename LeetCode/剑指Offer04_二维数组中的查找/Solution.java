package 剑指Offer04_二维数组中的查找;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/4 16:11
 */

/**
 * 从右上角开始，每次排除一行或者一列
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
