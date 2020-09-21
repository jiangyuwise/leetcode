package q2;

import util.ListNode;

/**
 * 两个链表相加
 * 数字是倒序存储的, 如 342 存储为 2 -> 4 -> 3
 * (2 -> 4 -> 3) + (5 -> 6 -> 4) = 342 + 465 = 807
 * 输出 7 -> 0 -> 8
 * @author admin
 * @date 2020/1/12 10:45
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode r = new ListNode(0), h = r;
        int incr = 0;
        while (p != null || q != null) {
            int tmp = 0;
            if (p != null) {
                tmp += p.val;
                p = p.next;
            }
            if (q != null) {
                tmp += q.val;
                q = q.next;
            }
            tmp += incr;
            r.next = new ListNode(tmp % 10);
            r = r.next;
            incr = tmp / 10;
        }
        if (incr > 0) {
            r.next = new ListNode(incr);
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode l1 = util.ListNode.build(new int[]{2, 4, 3});
        ListNode l2 = ListNode.build(new int[]{5, 6, 4});
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(ListNode.traverse(result));
    }
}
