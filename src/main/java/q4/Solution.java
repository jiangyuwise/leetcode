package q4;

/**
 * 计算 2 个有序数组的中位数
 * @author admin
 * @date 2020/1/14 10:30
 */
public class Solution {

    double middle(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if ((totalLength & 1) == 1) {
            int mid = totalLength / 2;
            return getK(nums1, nums2, mid + 1);
        } else {
            int mid1 = totalLength / 2 - 1;
            int mid2 = totalLength / 2;
            return (getK(nums1, nums2, mid1 + 1) + getK(nums1, nums2, mid2 + 1)) / 2.0;
        }
    }

    public int getK(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int mid = k / 2;
            int newIndex1 = Math.min(index1 + mid, length1) - 1;
            int newIndex2 = Math.min(index2 + mid, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);  // 排除 nums1[0] ~ nums1[k / 2]
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);  // 排除 nums2[0] ~ nums2[k / 2]
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.middle(nums1, nums2));
    }
}
