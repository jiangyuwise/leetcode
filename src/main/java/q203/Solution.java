package q203;

import util.ListNode;

/**
 * @author admin
 * @date 2020/9/11 09:45
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, q = dummy.next;
        while (q.val != val) {
            p = p.next;
            q = q.next;
        }
        p.next = q.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.build(nums);
        Solution solution = new Solution();
        head = solution.removeElements(head, 6);
        System.out.println(ListNode.traverse(head));
    }


}
