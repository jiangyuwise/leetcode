package q23;

import util.ListNode;

import java.util.PriorityQueue;

/**
 * @author admin
 * @date 2020/8/25 19:09
 */
public class Solution2 {

    public ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (ListNode node : lists) {
            queue.offer(node);
        }
        ListNode p = new ListNode(0), q = p;
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            p.next = tmp;
            p = p.next;
            tmp = tmp.next;
            if (tmp != null) {
                queue.offer(tmp);
            }
        }
        p.next = null;
        return q.next;
    }
}
