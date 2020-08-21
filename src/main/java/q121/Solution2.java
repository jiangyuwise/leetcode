package q121;

/**
 * @author admin
 * @date 2020/8/21 11:22
 */
public class Solution2 {

    // 暴力法
    public int max(int[] prices) {
        int max = 0;
        int tmp;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                tmp = prices[j] - prices[i];
                if (max < tmp) {
                    max = tmp;
                }
            }
        }
        return max;
    }
}
