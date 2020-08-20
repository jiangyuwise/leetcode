package q88;

import java.util.Arrays;

/**
 * 合并数组. 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * 采用倒序双指针法, 找出最大的元素, 放到 A 后面
 * @author admin
 * @date 2020/8/20 12:39
 */
public class Solution {

    public void merge(int[] A, int m, int[] B, int n) {
        int pa = m -1, pb = n - 1, index = m + n - 1;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1) {
                A[index] = B[pb--];
            } else if (pb == -1) {
                A[index] = A[pa--];
            } else if (A[pa] > B[pb]) {
                A[index] = A[pa--];
            } else {
                A[index] = B[pb--];
            }
            index--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        solution.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }


}
