package leetcode.array_linked;

import leetcode.LinkedListCycle_141;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesInPairs_24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode preNode = new ListNode(-1);
        preNode.next=head;
        ListNode temp = preNode;
        while (temp != null && temp.next != null) {
            ListNode firstNode = temp.next;
            ListNode  secondNode = temp.next.next;
            temp.next=secondNode;
            firstNode.next = secondNode.next;
            secondNode.next=firstNode;
            temp=firstNode;

        }
        return preNode.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
