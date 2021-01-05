package leetcode.random.kt

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
        val nums = intArrayOf(1, -1)
        val k = 1
        maxSlidingWindow(nums, k)
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

}