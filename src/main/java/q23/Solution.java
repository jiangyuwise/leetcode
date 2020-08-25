package q23;

import util.ListNode;

import java.util.PriorityQueue;

/**
 * @author admin
 * @date 2020/8/25 19:04
 */
public class Solution {

    public ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }
        ListNode p = new ListNode(0), q = p;
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
        }
        p.next = null;
        return q.next;
    }
}
