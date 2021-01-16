package leetcode.random.kt

/**
 * Linked List Cycle
 * pos=1
 */
object LinkedListCycle_141 {
    @JvmStatic
    fun main(args: Array<String>) {
        val data = intArrayOf(1, 2, 3, 4)

        val head = ListNode(data[0])
        val node1 =
            ListNode(data[1]).also { head.next = it }
        val node2 =
            ListNode(data[2]).also { node1.next = it }
        val node3 =
            ListNode(data[3]).also { node2.next = it }
        println(hasCycle(head))
    }
    /**
     * 解题思路：
     * 判断链表中是否有环，可以用快慢指针，因为如果有环到话，快慢指针一点会有相遇到时候
     */
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        var p = head
        var q = head
        while (q!!.next != null && q.next!!.next != null) {
            p = p!!.next
            q = q.next!!.next
            if (q === p) {
                return true
            }
        }
        return false
    }

    class ListNode internal constructor(var `val`: Int) {
        var next: ListNode? = null

    }
}