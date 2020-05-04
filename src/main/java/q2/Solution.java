package q2;

/**
 * 两个链表相加
 * (2 -> 4 -> 3) + (5 -> 6 -> 4) = 342 + 465 = 807
 * 输出 7 -> 0 -> 8
 * @author admin
 * @date 2020/1/12 10:45
 */
public class Solution {

    ListNode add(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p1 = l1, p2 = l2, head = node;
        int x, y, tmp, incr = 0;
        while (p1 != null || p2 != null) {
            x = 0;
            y = 0;
            if (p1 != null) {
                x = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                y = p2.val;
                p2 = p2.next;
            }
            tmp = x + y + incr;
            node.next = new ListNode(tmp % 10);
            node = node.next;
            incr = tmp / 10;
        }
        if (incr > 0) {
            node.next = new ListNode(incr);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        Solution solution = new Solution();
        ListNode result = solution.add(l11, l21);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
