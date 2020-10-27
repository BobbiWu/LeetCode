package leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 通过次数207,990提交次数327,220
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public static void main(String[] args) {

    }

    /**
     * 解题思路：根据题意知道层次遍历，且需要从做到右，那就符合了广度遍历了。
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResult = new ArrayList<>();
        if (root == null) {
            return allResult;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            allResult.add(result);

        }
        return allResult;
    }

    /**
     * DFS 深度搜索遍历，解题思路：递归的时候需要记录每一层的元素，所以需要有每一层的下标
     *
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> allResult = new ArrayList<>();
        if (root == null) {
            return allResult;
        }
        dfs(1, root, allResult);
        return allResult;
    }

    private static void dfs(int level, TreeNode node, List<List<Integer>> result) {
        if (result.size() < level) {
            result.add(new ArrayList<>());
        }
        result.get(level - 1).add(node.val);
        if (node.left != null) {
            dfs(level + 1, node.left, result);
        }
        if (node.right != null) {
            dfs(level + 1, node.right, result);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
