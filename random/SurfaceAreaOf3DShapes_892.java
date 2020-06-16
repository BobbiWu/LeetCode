package leetcode;

/**
 * 三维形体的表面积
 */
public class SurfaceAreaOf3DShapes_892 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};
//        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        surfaceArea(grid);
    }

    public static int surfaceArea(int[][] grid) {
        int N = grid.length;
        //总的正方体数量
        int totale = 0;
        //需要减去的面积
        int cutArea = 0;
        //循环每个数组
        for (int i = 0; i < N; i++) {
            //循环每个数组里面的元素
            for (int j = 0; j < N; j++) {
                totale += grid[i][j];
                //叠加的面积
                if (grid[i][j] > 0) {
                    cutArea += (grid[i][j] - 1);
                }
                if (i > 0) {
                    cutArea += Math.min(grid[i - 1][j], grid[i][j]);
                }
                if (j > 0) {
                    cutArea += Math.min(grid[i][j - 1], grid[i][j]);
                }
            }
        }
        return 6 * totale - 2 * cutArea;
    }
}
