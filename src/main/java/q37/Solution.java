package q37;

/**
 * @author admin
 * @date 2020/8/28 22:13
 */
public class Solution {

    int n = 3;
    int N = n * n;
    int[][] rows = new int[N][N + 1];
    int[][] cols = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];

    char[][] board;
    boolean solved = false;

    public boolean check(int num, int row, int col) {
        int idx = (row / n) * n + col / n;
        return rows[row][num] + cols[col][num] + boxes[idx][num] == 0;
    }

    public void set(int num, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][num] ++;
        cols[col][num] ++;
        boxes[idx][num]++;
        board[row][col] = (char) (num + '0');
    }

    public void unset(int num, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][num] --;
        cols[col][num] --;
        boxes[idx][num]--;
        board[row][col] = '.';
    }

    public void setNext(int row, int col) {
        if ((col == N - 1) && (row == N - 1)) {
            solved = true;
        } else {
            if (col == N - 1) {
                dfs(row + 1, 0);
            } else {
                dfs(row, col + 1);
            }
        }
    }

    public void dfs(int row, int col) {
        if (board[row][col] == '.') {
            for (int num = 1; num < 10; num++) {
                if (check(num, row, col)) {
                    set(num, row, col);
                    setNext(row, col);
                    if (!solved) {
                        unset(num, row, col);
                    }
                }
            }
        } else {
            setNext(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int num = ch - '0';
                    set(num, i, j);
                }
            }
        }
        dfs(0, 0);
    }
}
