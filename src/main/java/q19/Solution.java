package q19;

import util.ListNode;

/**
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 使用双指针法, 使用哑节点减少判断
 * @author admin
 * @date 2020/8/20 17:47
 */
public class Solution {

    public ListNode k(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, q = dummy;
        for (int i = 0; i <= n; i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return dummy.next;
    }

    @SuppressWarnings("Duplicated")
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        int[] nums = {2, 3, 4, 5};
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        Solution solution = new Solution();

        ListNode result = solution.k(p, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}