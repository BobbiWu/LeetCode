package leetcode;


/**
 * Reverse a singly linked list.
 */
public class ReverseLinkedList_206 {


    public static void main(String[] args) {
        int data[] = {1, 2, 3, 4, 5};
        //带头结点
        ListNode p = new ListNode();
        ListNode head = new ListNode(data[0]);
        p.next = head;
        //不带头节点
        //ListNode head = new ListNode(data[0]);
        ListNode node1 = head.next = new ListNode(data[1]);
        ListNode node2 = node1.next = new ListNode(data[2]);
        ListNode node3 = node2.next = new ListNode(data[3]);
        node3.next = new ListNode(data[4]);
        //不带头节点
        //ListNode listNode = reverseList(head);
        ListNode listNode = reverseListHead(p);
    }

    //无头节点反转
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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

    //带头节点带反转
    public static ListNode reverseListHead(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next ;
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
        //因为头节点带下一个结点带信息，会打印反转后第一个结点
        System.out.println("head     " + head.next.val);
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int x) {
            val = x;
        }
    }
}

