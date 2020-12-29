package leetcode.random.kt

import javax.print.attribute.IntegerSyntax

/**
 *121. 买卖股票的最佳时机
 *
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。



示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
object BestTimeToBuyAndSellStock_121 {
    @JvmStatic
    fun main(args: Array<String>) {
        val prices = intArrayOf(1,2)
        print(maxProfit2(prices))
    }

    //暴力法
    fun maxProfit(prices: IntArray): Int {
        var maxprofit = 0
        for (i in 0 until prices.size - 1) {
            for (j in 1 until prices.size) {
                var value = prices[j] - prices[i]
                if (value > maxprofit) {
                    maxprofit = value
                }
            }
        }
        return maxprofit
    }

    //一次循环
    fun maxProfit2(prices: IntArray): Int {
        var maxprofit = 0
        var minporfit = Integer.MAX_VALUE
        for (i in prices.indices) {
            if (prices[i] < minporfit) {
                minporfit = prices[i]
            } else if (prices[i] - minporfit > maxprofit) {
                maxprofit = prices[i] - minporfit
            }
        }
        return maxprofit
    }
}