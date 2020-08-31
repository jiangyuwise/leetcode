package q54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2020/8/31 15:48
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = 0;
        int vx = 1, vy = 0;
        for (int i = 0; i < m * n; i ++) {
            result.add(matrix[y][x]);
            matrix[y][x] = 0;
            if (x + vx == -1 || x + vx == n || y + vy == -1 || y + vy == m || matrix[y + vy][x + vx] == 0) {
                if (vx != 0) {
                    vy = vx;
                    vx = 0;
                } else {
                    vx = -vy;
                    vy = 0;
                }
            }
            x += vx;
            y += vy;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }
}
