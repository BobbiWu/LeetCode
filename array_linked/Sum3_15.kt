package leetcode.array_linked

import java.util.*

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
object Sum3_15 {
    @JvmStatic
    fun main(args: Array<String>) {
//        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
//        val nums = intArrayOf(-2,0,0,2,2) -4，-4，-3，-2，-1，0，2
        val nums = intArrayOf(0, -4, -1, -4, -2, -3, 2)
        val sum = threeSum(nums)
        sum.map {
            for (i in it.indices) {
                println(it[i])
            }
        }
    }

    /**
     * 解题思路：
     * 排序+双指针
     */
    @JvmStatic
    fun threeSum(nums: IntArray): List<List<Int>> {
        val len = nums.size
        val sumList = mutableListOf<List<Int>>()
        //排序
        Arrays.sort(nums)
        if (len < 3) return sumList;
        for (i in nums.indices) {
            if (nums[0] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue
            var L = i + 1    //除了排除的第一个元素
            var R = len - 1  //除了排除的最后一个元素
            while (L < R) {
                val sum = nums[i] + nums[L] + nums[R]
                when {
                    sum == 0 -> {
                        val list = mutableListOf<Int>()
                        list.add(nums[i])
                        list.add(nums[L])
                        list.add(nums[R])
                        sumList.add(list)
                        while (L < R && nums[L] == nums[L + 1]) L++ //去重
                        while (L < R && nums[R] == nums[R - 1]) R-- //去重
                        L++
                        R--
                    }
                    sum < 0 -> {
                        L++
                    }
                    else -> {
                        R--
                    }
                }
            }
        }
        return sumList
    }
}