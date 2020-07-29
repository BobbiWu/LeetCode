package leetcode.tree;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class BinaryTreePreorderTraversal_144 {

    public static void main(String[] args) {
//        2,1,3,null,4
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = treeNode.right = new TreeNode(2);
        treeNode1.left = new TreeNode(3);
        preorderTraversal2(treeNode);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        findNode(root, list);
        for (int value : list) {
            System.out.println(value);
        }
        return list;
    }

    /**
     * 递归
     * 前序遍历：中 左 右
     */
    public static void findNode(TreeNode root, List<Integer> list) {
        if (root != null) {
            //先添加中
            list.add(root.val);
            //递归查找左
            if (root.left != null) {
                findNode(root.left, list);
            }
            //递归查找右
            if (root.right != null) {
                findNode(root.right, list);
            }
        }
    }

    /**
     * 非递归
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.pollLast();
            list.add(treeNode.val);
            if (treeNode.right!=null){
                queue.add(treeNode.right);
            }
            if (treeNode.left!=null){
                queue.add(treeNode.left);
            }
        }
        for (int value : list) {
            System.out.println(value);
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
