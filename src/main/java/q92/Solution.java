package q92;

import util.ListNode;

/**
 * 反转链表 m 到 n 的节点
 * 1, 2, 3, 4, 5, null. m = 2, n = 4
 * 第 2 个循环结束后, cur 指向 5
 * [2, 3, 4] 反转后, tail 表示 2
 * con 表示连接 4 的前一个节点.
 *
 * @author admin
 * @date 2020/8/23 15:40
 */
public class Solution {

    public ListNode reverse(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, pre = null;
        while (m > 1) { // 循环了 m - 1 次
            pre = cur;
            cur = cur.next;
            m --;
            n --;
        }
        ListNode con = pre, tail = cur, tmp;
        while (n > 0) { // 循环了 n - m + 1次
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            n --;
        }
        if (con != null) {
            con.next = pre;
        } else { // 例如 直接反转 [1, 2, 3, 4]. 则 head 就是 4
            head = pre;
        }
        tail.next = cur;
        return head;
    }

}
