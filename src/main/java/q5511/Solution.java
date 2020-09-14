package q5511;

/**
 * @author admin
 * @date 2020/9/13 10:44
 */
public class Solution {

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int count = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                boolean flagRow = false, flagCol = false;
                if (mat[i][j] == 1) {
                    for (int row = 0; row < m; row ++) {
                        if (row != i && mat[row][j] == 1) {
                            flagRow = true;
                            break;
                        }
                    }
                    for (int col = 0; col < n; col ++) {
                        if (col != j && mat[i][col] == 1) {
                            flagCol = true;
                            break;
                        }
                    }
                    if (! flagRow && !flagCol) {
                        count ++;
                    }
                }
            }
        }
        return count;
    }
}
