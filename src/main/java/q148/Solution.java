package q148;

import util.ListNode;

/**
 * 对单链表排序, 要求时间复杂度为 O(n log n)
 *
 * 先二分法切割链表, 直至成为一个节点的小链表.
 * 再对小链表排序, 逐渐形成一个大链表
 * @author admin
 * @date 2020/8/23 17:02
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow 就是中间节点了.
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0); // 新的链表
        ListNode result = h;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return result.next;
    }
}
