package leetcode.random.kt

import leetcode.recursion.ValidateBinarySearchTree_98
import java.util.*

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
object ValidateBinarySearchTree {
    @JvmStatic
    fun main(args: Array<String>) {
    }

    /**
     * 解题思路：
     * 因为满足 左子树<中间接点<右子树，因此可用中序便利，因为中序便利后是升序
     */
    fun isValidBST(root: TreeNode?): Boolean {
        val stack = Stack<TreeNode>()
        var current: TreeNode? = root
        var value = -Double.MAX_VALUE
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            if (current.`val` <= value) return false
            value = current.`val`.toDouble()
            current = current.right
        }
        return true
    }

    class TreeNode internal constructor(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

    }
}