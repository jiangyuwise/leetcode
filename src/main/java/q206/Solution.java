package q206;

import util.ListNode;

/**
 * 反转单链表
 *
 * 递归
 * @author admin
 * @date 2020/8/20 23:40
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head);
        head.next.next = head.next;
        head.next = null;
        return p;
    }
}
