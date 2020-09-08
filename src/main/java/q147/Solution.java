package q147;

import util.ListNode;

/**
 * @author admin
 * @date 2020/9/8 15:49
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, cur = head.next;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (cur != null) {
            if (pre.val < cur.val) { // 已经有序
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                while (p.next.val < cur.val) {
                    p = p.next;
                }
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}
