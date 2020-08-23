package q24;

import util.ListNode;

/**
 * 两两交换链表中的节点
 * @author admin
 * @date 2020/8/23 15:00
 */
public class Solution {

    public ListNode swap(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head.next;

        p.next = swap(q.next);
        q.next = p;
        return q;
        }
}
