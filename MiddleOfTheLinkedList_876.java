package leetcode;

/**
 * Definition for singly-linked list.
 */
public class MiddleOfTheLinkedList_876 {
    public static void main(String[] args) {
        int data[] = {1, 2, 3, 4,5};
        ListNode head = new ListNode(-1);
        ListNode node = head.next = new ListNode(data[0]);
        ListNode node1 = node.next = new ListNode(data[1]);
        ListNode node2 = node1.next = new ListNode(data[2]);
        ListNode node3 = node2.next = new ListNode(data[3]);
        node3.next = new ListNode(data[4]);
        System.out.println( middleNode(head).val);
    }

    /**
     *解题思路：
     * 用快慢指针，快指针走两步，慢指针走一步，当快指针到尾结点到时候
     * 慢指针就是中点了
     */
    public static ListNode middleNode(ListNode head) {
        ListNode q = head;
        ListNode p = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        System.out.println(p.val);
        System.out.println(q.val);
        if (q.next!=null){
            return p.next;
        }
        return p;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
