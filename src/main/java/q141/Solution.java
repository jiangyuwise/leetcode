package q141;

import util.ListNode;

/**
 * 判断链表是否有环
 *
 * @author admin
 * @date 2020/8/20 22:25
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = head, q = head.next;
        while (p != q) {
            if (q == null || q.next == null) {
                return false;
            }
            p = p.next;
            q = q.next.next;
        }
        return true;
    }
}
