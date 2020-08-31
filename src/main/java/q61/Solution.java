package q61;

import util.ListNode;

/**
 * @author admin
 * @date 2020/8/31 21:31
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = head;
        if (head == null) {
            return null;
        }
        int length;
        for (length = 1; tail.next != null; length ++) {
            tail = tail.next;
        }
        tail.next = head;

        ListNode newTail = head;
        for (int i = 0; i < length - k % length - 1; i ++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
