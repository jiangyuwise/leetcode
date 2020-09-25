package q24;

import util.ListNode;

/**
 * 两两交换链表中的节点
 * @author admin
 * @date 2020/8/23 15:00
 */
public class Solution2 {

    public ListNode swap(ListNode head) {
        ListNode pre = new ListNode(0), h = pre;
        pre.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode p = pre.next;
            ListNode q = pre.next.next;
            pre.next = q;
            p.next = q.next;
            q.next = p;
            pre = p;
        }
        return h.next;
    }
}
