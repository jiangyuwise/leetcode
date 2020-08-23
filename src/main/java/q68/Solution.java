package q68;

import util.ListNode;

/**
 * 分隔链表, 使 小于 x 的节点都在 大于等于 x 的节点之前.
 *
 * 双指针法, 使用带有哑节点的 2 个指针 small, big. small 的元素都小于 x, 其余的元素都在 big中, 最后连接 2 者即可.
 * 使用哑节点可以有效减少判断.
 * @author admin
 * @date 2020/8/23 18:50
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode p = head;
        ListNode pSmall = small;
        ListNode pBig = big;
        while (p != null) {
            if (p.val < x) {
                small.next = p;
                small = small.next;
            } else {
                big.next = p;
                big = big.next;
            }
            p = p.next;
        }
        big.next = null;
        small.next = pBig.next;
        return pSmall.next;
    }
}
