package leetcode;

/**
 * Definition for singly-linked list.
 */
public class RemoveDuplicatesFromSortedList_83 {
    public static void main(String[] args) {
        int data[] = {1, 1, 2, 3, 3};
        ListNode node = new ListNode(data[0]);
        ListNode node1 = node.next = new ListNode(data[1]);
        ListNode node2 = node1.next = new ListNode(data[2]);
        ListNode node3 = node2.next = new ListNode(data[3]);
        ListNode listNode = deleteDuplicates(node);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }

    /**
     *解题思路：
     * 判断当前结点和当前下一个结点是否相等，相等则指向下下个结点，不相等则往下执行
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
