package leetcode.random.kt

object QuickSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val ints = intArrayOf(5, 0, 11, 88, 99, 3, 4, 9, 8)
        val sort = quickSort(ints, 0, ints.size - 1)
        for (value in sort) {
            println(value)
        }
    }

    /**
     * 快排思路：
     * 1.先找到一个参照对象，数组里任意一个数都可以
     * 2.然后循环数组让小于 参照对象的 排到左边，让大于参照对象的排右边
     */
    private fun quickSort(ints: IntArray, begin: Int, end: Int): IntArray {
        if (end<=begin) return ints
        val partition = partition(ints, begin, end)
        quickSort(ints, begin, partition-1)
        quickSort(ints, partition + 1, end)
        return ints;
    }

    //获取参照元素
    private fun partition(a: IntArray, begin: Int, end: Int): Int {
        //参照对象
        //小于参照对象的元素 放在左边
        var counter = begin
        for (i in begin until end) {
            if (a[i] < a[end]) {
                val temp = a[counter]
                a[counter] = a[i]
                a[i] = temp
                counter++
            }
        }
        //把参照元素凡放中间
        val temp = a[end]
        a[end] = a[counter]
        a[counter] = temp
        return counter
    }
}