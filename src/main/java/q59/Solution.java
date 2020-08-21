package q59;

import java.util.Arrays;

/**
 * 给定 n, 将 1 ~ n^2 按顺时针填入矩阵中.
 * 螺旋矩阵
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * @author admin
 * @date 2020/8/21 14:51
 */
public class Solution {

    public int[][] matrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }
        int[][] result = new int[n][n];
        int x = 0, y = 0, vx = 1, vy = 0;
        int length = n * n;
        for (int i = 1; i <= length; i++) {
            if (x + vx == n) {
                vx = 0;
                vy = 1;
            }
            if (y + vy == n) {
                vy = 0;
                vx = -1;
            }
            if (x + vx < 0) {
                vx = 0;
                vy = -1;
            }
            if (y + vy < 0) {
                vy = 0;
                vx = 1;
            }
            if (result[y + vy][x + vx] != 0) {
                if (vx == 0) {
                    vx = -vy;
                    vy = 0;
                } else {
                    vy = vx;
                    vx = 0;
                }
            }
            result[y][x] = i;
            x += vx;
            y += vy;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.matrix(1);
        for (int[] nums : result) {
            System.out.println(Arrays.toString(nums));
        }
    }
}
