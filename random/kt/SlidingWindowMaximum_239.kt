package leetcode.random.kt

import java.util.*
import kotlin.math.max

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 */
object SlidingWindowMaximum_239 {
    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
        val k = 3
        val arrays = maxSlidingWindow2(nums, k)
        arrays.forEach {
            println(it)
        }
    }


    /**
     * 暴力法：
     * 循环的比较
     */
    private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        if (n * k == 0) return IntArray(0)
        val size = n - k + 1
        val output = IntArray(size)
        for (i in 0 until size) {
            var max = Int.MIN_VALUE
            for (j in i until k + i) {
                max = Math.max(max, nums[j])
            }
            output[i] = max
        }
        return output
    }

    /**
     * 双端队列
     * 解题思路：
     * 1. 用一个双端队列来维护最大值，在窗口范围内，如果队列为空，则把数组的下标全部放入队列，
     * 如果队列不为空的情况下，循环判断数组 i 下标的值，大于或者小于 队列的最后一个下标的值，如果队列最后一个下标的值小于
     * 则队尾的出列，否则加入到队尾。
     * 2. 再判断队头的范围是否在 k 范围之内，不在则删除队头
     * 3. 把队列的值赋值给数组
     *
     */
    private fun maxSlidingWindow2(nums: IntArray, k: Int): IntArray {
        val arrays = IntArray(nums.size - k + 1)
        val maxQueue = LinkedList<Int>()
        var index = 0
        for (i in nums.indices) {
            while (maxQueue.isNotEmpty() && nums[maxQueue.peekLast()] <= nums[i]) {
                maxQueue.pollLast()
            }
            maxQueue.addLast(i)
            if (maxQueue.peekFirst() == i - k) {
                maxQueue.pollFirst()
            }
            if (i >= k - 1) {
                arrays[index++] = nums[maxQueue.peekFirst()]
            }
        }
        return arrays
    }
}