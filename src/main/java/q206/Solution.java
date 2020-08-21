package q206;

import util.ListNode;

/**
 * 反转单链表
 * @author admin
 * @date 2020/8/20 23:40
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
