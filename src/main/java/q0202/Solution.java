package q0202;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 使用快慢指针
 * @author admin
 * @date 2020/8/20 17:35
 */
public class Solution {

    public int k(ListNode head, int k) {
        ListNode p = head, q = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        int[] nums = {2, 3, 4, 5};
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        Solution solution = new Solution();
        System.out.println(solution.k(p, 2));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
