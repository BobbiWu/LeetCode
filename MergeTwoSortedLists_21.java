package leetcode;

/**
 * Merge Two Sorted Lists
 * 合并个有序的链表
 */
public class MergeTwoSortedLists_21 {

    public static void main(String[] args) {

        int l1[] = {1, 2, 4};
        int l2[] = {1, 3, 4};
        //l1
        ListNode node = new ListNode(l1[0]);
        ListNode node1 = node.next = new ListNode(l1[1]);
        node1.next = new ListNode(l1[2]);
        //l2
        ListNode l2Node = new ListNode(l2[0]);
        ListNode l2Node1 = l2Node.next = new ListNode(l2[1]);
        l2Node1.next = new ListNode(l2[2]);

        ListNode listNode = mergeTwoLists(node, l2Node);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
        System.out.println(listNode.next.next.next.val);
        System.out.println(listNode.next.next.next.next.val);
        System.out.println(listNode.next.next.next.next.next.val);


    }

    /**
     * 解题思路：
     * 合并两个有序的链表，可以遍历循环比较，然后插入，（需要注意移动两个被比较的链表的指针）
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode();
        ListNode newNodeHead = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newNodeHead.next = l1;
                l1 = l1.next;
            } else {
                newNodeHead.next = l2;
                l2 = l2.next;
            }
            newNodeHead = newNodeHead.next;
        }
        newNodeHead.next = l1 == null ? l2 : l1;
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
