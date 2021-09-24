package leetcode.random.kt
import java.util.*
import kotlin.collections.HashMap

/**
 * 20. 有效括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。


示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 *
 */
object ValidParentheses_20 {
    @JvmStatic
    fun main(args: Array<String>) {
        val parentheses = "()[]{}"
        println( validParentheses(parentheses))
    }

    private fun validParentheses(parentheses: String): Boolean {
        val map = HashMap<Char, Char>()
        val stack = Stack<Char>()
        map[')'] = '('
        map[']'] = '['
        map['}'] = '{'

        for (i in parentheses.indices) {
            val value = parentheses[i]
            if (map.containsKey(value)) {
                val element = if (stack.empty()) '#' else stack.pop()
                if (element!= map[value]) return false
            } else {
                stack.push(value)
            }
        }
        return stack.isEmpty()
    }

}