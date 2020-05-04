package q4;

/**
 * 计算 2 个有序数组的中位数
 * @author admin
 * @date 2020/1/14 10:30
 */
public class Solution {

    double middle(int[] nums1, int[] nums2) {
        int[] tmp;
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2 + 1]) / 2.0;
            } else {
                return nums2[n / 2 - 1];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2 + 1]) / 2.0;
            } else {
                return nums2[m / 2 - 1];
            }
        }
        tmp = new int[m + n];
        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    tmp[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    tmp[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] <= nums2[j]) {
                tmp[count++] = nums1[i++];
            } else {
                tmp[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0) {
            return (tmp[count / 2 - 1] + tmp[count / 2 + 1]) / 2.0;
        }
        return tmp[count / 2];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        Solution solution = new Solution();
        System.out.println(solution.middle(nums1, nums2));
    }
}
