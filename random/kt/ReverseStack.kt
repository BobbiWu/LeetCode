package leetcode.random.kt

import java.util.*

/**
 * 一个栈依次压入1,2,3,4,5，那么从栈顶部到栈底部分别为5,4,3,2,1.将这个栈转置后，从栈顶到栈底为1,2,3,4,5.也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 * <p>
 * 示例 ：
 * <p>
 * 输入：stack = [1,2,3,4,5], 从栈顶部到栈底部分别为 5,4,3,2,1
 * 输出：从栈顶到栈底分别为 1,2,3,4,5
 */
object ReverseStack {
    @JvmStatic
    fun main(args: Array<String>) {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        stack.push(4)
        stack.push(5)

        reverseStack(stack)
    }

    private fun reverseStack(stack: Stack<Int>) {
        if (stack.isEmpty()) return
        val top = stack.pop()
        //所有元素现出栈
        reverseStack(stack)
        addStackBottom(stack,top)

    }

    private fun addStackBottom(stack: Stack<Int>,top:Int){
        if (stack.isEmpty()){
            stack.push(top)
            return
        }
        val item = stack.pop()
        addStackBottom(stack, top)
        stack.push(item)
    }
}