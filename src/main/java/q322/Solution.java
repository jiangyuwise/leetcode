package q322;

import java.util.Arrays;

/**
 * 兑换零钱, coins = [1, 2, 5] 表示 3 种硬币
 * 给定金额, 返回需要的最少硬币数.
 * 如果无法兑换, 则返回 -1
 * @author admin
 * @date 2020/8/24 15:17
 */
public class Solution {
    int result = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        dfs(coins, amount, coins.length -1, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public void dfs(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            result = Math.min(result, count);
        }
        if (index < 0) {
            return;
        }
        for (int i = amount / coins[index]; i >= 0 && i + count < result; i--) {
            dfs(coins, amount - i * coins[index], index - 1, i + count);
        }
    }

}
