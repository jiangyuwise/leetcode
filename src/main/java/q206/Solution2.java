package q206;

import util.ListNode;

/**
 * 循环
 * @author admin
 * @date 2020/8/23 15:31
 */
public class Solution2 {

    public ListNode reverse(ListNode head) {
        ListNode pre = null, tmp;
        while (head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
