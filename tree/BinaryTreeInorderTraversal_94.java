package leetcode.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeInorderTraversal_94 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = treeNode.right = new TreeNode(2);
        treeNode1.left = new TreeNode(3);
//        inorderTraversal(treeNode);
        System.out.println(inorderTraversal2(treeNode));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        findNode(root, list);
        return list;
    }

    /**
     * 递归
     */
    public static void findNode(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                findNode(root.left, res);
            }
            res.add(root.val);
            System.out.println(root.val);
            if (root.right != null) {
                findNode(root.right, res);
            }
        }

    }

    /**
     * 非递归
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            //查找左子树全部进栈
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            //出栈存并且进去数组
            currentNode = stack.pop();
            list.add(currentNode.val);
            //查找右子树
            currentNode = currentNode.right;

        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
