package leetcode;

/**
 * Convert Binary Number in a Linked List to Integer
 *  二进制链表转整数
 */
public class ConvertBinaryNumberInALinkedListToInteger_1290 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = node.next = new ListNode(0);
        node1.next = new ListNode(1);
        System.out.println(getDecimalValue(node));
    }

    /**
     * 解题思路:
     * 因为链表对二进制已经是正确对顺序了，所以只要取出用进制转换就可以了
     * [1,0,1] 二进制转十进制：
     * 0*2+1 = 1
     * 1*2+0 = 2
     * 2*2+1 = 5；
     */
    public static int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }

        return sum;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
