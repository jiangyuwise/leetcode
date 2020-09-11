package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @date 2020/8/20 22:26
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode build(int[] nums) {
        ListNode head = new ListNode(0), p = head;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return head.next;
    }

    public static List<Integer> traverse(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return nums;
    }
}
