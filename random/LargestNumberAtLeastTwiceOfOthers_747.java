package leetcode.random;

import java.util.Arrays;

/**
 * 747. 至少是其他数字两倍的最大数
 * <p>
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestNumberAtLeastTwiceOfOthers_747 {
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        System.out.println(dominantIndex(nums));
    }


    private static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int index = 0;
        int m1 = -1;
        int m2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m1) {
                m2 = m1;
                m1 = nums[i];
                index = i;
            } else if (nums[i] > m2) {
                m2 = nums[i];
            }
        }
        return m1 >= 2 * m2 ? index : -1;
    }

}
