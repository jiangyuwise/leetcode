package q6;

/**
 * Z 字变形
 * @author admin
 * @date 2020/5/5 15:23
 */
public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        char[][] arr = new char[numRows][length];
        int x = 0, y = 0, vx = 0, vy = 1;
        for (int i = 0; i < length; i++) {
            arr[y][x] = s.charAt(i);
            if (y + vy == numRows) {
                vy = -vy;
                vx = 1;
            }
            if (y + vy == -1) {
                vy = -vy;
                vx = 0;
            }
            x += vx;
            y += vy;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i][j] != '\0') {
                    builder.append(arr[i][j]);
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.convert("LEETCODEISHIRING", 1);
        System.out.println(result);
    }
}
