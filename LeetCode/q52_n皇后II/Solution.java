package q52_n皇后II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/10 9:37
 */
public class Solution {
    class Pair {
        public int x;
        public int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int totalNQueens(int n) {
        List<List<Pair>> solutions = new ArrayList<>();
        List<Pair> solution = new ArrayList<>();
        dfs(solutions, solution, 0, n);
        return solutions.size();
    }

    public void dfs(List<List<Pair>> solutions, List<Pair> solution, int curRow, int n) {
        if (curRow == n) {
            solutions.add(new ArrayList<>(solution));
        }
        for (int col = 0; col < n; col++) {
            if (isValid(solution, curRow, col)) {
                solution.add(new Pair(curRow, col));
                dfs(solutions, solution, curRow + 1, n);
                solution.remove(solution.size() - 1);
            }
        }
    }

    public boolean isValid(List<Pair> solution, int row, int col) {
        for (Pair pair : solution) {
            if (col == pair.y || row + col == pair.x + pair.y || row - col == pair.x - pair.y) {
                return false;
            }
        }
        return true;
    }
}
