package q36_有效的数独;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/30 13:31
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] block = new int[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';// 1-9 变成下标 0-8
                    int indexBlock = (i / 3) * 3 + (j / 3);//计算是哪一块 3*3的小块
                    //行
                    if (rows[i][num] == 1) {
                        return false;
                    }else {
                        rows[i][num] = 1;
                    }
                    //列
                    if (cols[j][num] == 1) {
                        return false;
                    }else {
                        cols[j][num] = 1;
                    }
                    //块
                    if (block[indexBlock][num] == 1) {
                        return false;
                    }else {
                        block[indexBlock][num] = 1;
                    }
                }
            }
        }
        return true;
    }
}
