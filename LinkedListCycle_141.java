package leetcode;

/**
 * Linked List Cycle
 * pos=1
 */
public class LinkedListCycle_141 {
    public static void main(String[] args) {
        int data[] = {1, 2, 3, 4};

        ListNode head = new ListNode(data[0]);
        ListNode node1 = head.next = new ListNode(data[1]);
        ListNode node2 = node1.next = new ListNode(data[2]);
        ListNode node3 = node2.next = new ListNode(data[3]);
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p = head;
        ListNode q = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
            if (q.next == p) {
                return true;
            }
        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
