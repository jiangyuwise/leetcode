package q51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2020/8/31 14:24
 */
public class Solution {
    int[] rows;
    int[] pass; // 正对角线
    int[] neg; // 反对角线
    int n;
    List<List<String>> result = new ArrayList<>();
    int[] queens;

    public boolean check(int row, int col) {
        int res = rows[col] + pass[row - col + 2 * n] + neg[row + col];
        return res == 0;
    }

    public void set(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        pass[row - col + 2 * n] = 1;
        neg[row + col] = 1;
    }

    public void unset(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        pass[row - col + 2 * n] = 0;
        neg[row + col] = 0;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            int col = queens[i];
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < col; j ++) {
                builder.append(".");
            }
            builder.append("Q");
            for (int j = 0; j < n - 1 - col; j ++) {
                builder.append(".");
            }
            solution.add(builder.toString());
        }
        result.add(solution);
    }

    public void dfs(int row) {
        for (int col = 0; col < n; col ++) {
            if (check(row, col)) {
                set(row, col);
                if (row + 1 == n) {
                    addSolution();
                } else {
                    dfs(row + 1);
                }
                unset(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        pass = new int[ 4 * n - 1];
        neg = new int[2 * n - 1];
        queens = new int[n];

        dfs(0);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> result = solution.solveNQueens(8);
        result.forEach(System.out::println);
    }
}
