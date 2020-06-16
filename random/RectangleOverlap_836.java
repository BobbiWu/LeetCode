package leetcode;

/**
 * 矩形重叠
 */
public class RectangleOverlap_836 {
    public static void main(String[] args) {
//        int[] rec1 = {0, 0, 2, 2};
//        int[] rec2 = {1, 1, 3, 3};
        int[] rec1 = {4,0,6,6};
        int[] rec2 = {-5,-3,4,2};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }

    /**
     * 解题思路：
     * 1.判断两条线是否相交
     * 2.如果相交 一定会存在以下条件：
     * 两条线 x 的最大值一定会小于 两线 y 的最小值
     */
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) && Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]));
    }
}
