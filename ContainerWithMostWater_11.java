package leetcode;

/**
 * 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int height[] = {2, 3, 4, 5, 18, 17, 6};
        int height2[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /**
     * 解题思路：
     * 循环比较找出木板的最小值，在和 x 坐标相乘，当左边当值大于最右边当值，让右边向左边移动，
     * 让所有元素都能比较到
     */
    public static int maxArea(int[] height) {
        int i = height.length - 1;
        int j = 0;
        int maxArea = 0;
        while (j < i) {
            int area = Math.min(height[j], height[i]) * (i - j);
            maxArea = Math.max(area, maxArea);
            if (height[j] < height[i]) {
                j++;
            } else {
                i--;
            }
        }
        return maxArea;
    }
}
