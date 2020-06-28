package leetcode.stack_queue;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LargestRectangleInHistogram_84 {
    public static void main(String[] args) {
        int heights[] = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    /**
     * 暴力法
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            //遍历循环找到heights[i]左边第一个小于的
            while (left >= 0 && heights[left] >= heights[i]) {
                left -= 1;
            }
            //遍历循环找到heights[i]右边第一个小于的
            while (right < n && heights[right] >= heights[i]) {
                right += 1;
            }
            area = Math.max(area, heights[i] * (right - left - 1));
        }
        return area;

    }
}
