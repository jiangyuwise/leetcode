package q21;

import util.ListNode;

/**
 * 合并 2 个链表
 * @author admin
 * @date 2020/8/23 14:35
 */
public class Solution {

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), node = head, p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    head.next = new ListNode(p1.val);
                    p1 = p1.next;
                } else {
                    head.next = new ListNode(p2.val);
                    p2 = p2.next;
                }
            } else if (p1 != null) {
                head.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                head.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            head = head.next;
        }
        return node.next;
    }


}
