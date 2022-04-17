package leetcode.interview;


import java.util.Stack;

/**
 * 矩阵中的最大矩形
 * <p>
 * 给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 注意：此题 matrix 输入格式为一维 01 字符串数组。
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输入：matrix = ["10100","10111","11111","10010"]
 * 输出：6
 * 解释：最大矩形如上图所示。
 */
public class MaximalRectangle {

    public static void main(String[] args) {

    }

    /**
     * 解题思路： 把矩阵以行作为直方图的基线，上下相邻的作为直方图的高，得出不同的直方图，比较出中直方图中面积最大的矩形，
     * 第一行：1 0 1 0 0
     * 第二行：2 0 2 1 1
     * 第三行：3 1 3 2 2
     * 第四行：4 0 0 1 0
     */
    private static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '0') {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
        }
        maxArea = Math.max(maxArea, largestRectangle(heights));
        return maxArea;
    }

    private static int largestRectangle(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && stack.peek() >= heights[i]) {
                int height = stack.pop();
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = stack.pop();
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea,height*width);
        }
        return maxArea;
    }
}
