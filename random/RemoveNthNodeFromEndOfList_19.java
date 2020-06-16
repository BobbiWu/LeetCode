package leetcode;

/**
 * Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEndOfList_19 {
    public static void main(String[] args) {
        int data[] = {1, 2, 3, 4};
        //l1
        ListNode node = new ListNode(data[0]);
        ListNode node1 = node.next = new ListNode(data[1]);
        ListNode node2 = node1.next = new ListNode(data[2]);
        node2.next = new ListNode(data[3]);
        ListNode listNode = removeNthFromEnd(node, 2);
        System.out.println(listNode.val);
    }

    /**
     *解题思路：
     * 用快慢指针，快指针先走 n 步，然后慢指针跟快指针同时走，当快指针到尾结点到时候，
     * 慢指针就是需要移除的结点的上一个结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newNode = new ListNode();
        newNode.next = head;
        ListNode q = newNode;
        ListNode p = newNode;
        for (int i = 1; i <= n+1; i++) {
            q = q.next;
        }
        while (q != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return newNode.next;
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
