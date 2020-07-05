package leetcode.stack_queue;

import java.util.ArrayList;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 */
public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        int nums[] = {1,  -1};
        int k = 1;
        maxSlidingWindow(nums, k);
    }

    /**
     * 暴力法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n*k==0) return new int[0];
        int [] output = new int[n - k + 1];
        for (int i = 0; i < (n - k + 1); i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k+i; j++) {
                max=Math.max(max,nums[j]);
            }
            output[i]=max;
        }
        return output;
    }
}
