package q6;

/**
 * @author admin
 * @date 2020/5/5 15:50
 */
public class ArrTest {

    public static void main(String[] args) {
        int row = 3, col = 4;
        int[][] arr = new int[row][col];
        int count = 1;
        // 横向赋值
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = count++;
            }
        }

        // 横向遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%-2d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
