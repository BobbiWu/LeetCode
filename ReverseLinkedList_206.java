package leetcode;

/**
 * Reverse a singly linked list.
 */
public class ReverseLinkedList_206 {


    public static void main(String[] args) {
        int data[] = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(data[0]);
        ListNode node1 = head.next = new ListNode(data[1]);
        ListNode node2 = node1.next = new ListNode(data[2]);
        ListNode node3 = node2.next = new ListNode(data[3]);
        ListNode node4 = node3.next = new ListNode(data[4]);
        ListNode listNode = reverseList(head);
        System.out.println(listNode.val);
    }

    //无头节点反转
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

