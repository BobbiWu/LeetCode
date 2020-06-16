package leetcode;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductOfArrayExceptSelf_238 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        int[] ints = productExceptSelf(nums);
        for (int value : ints) {
            System.out.println(value);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int j = 1;
        //当前下标左边的乘积
        for (int i = 0; i < nums.length; i++) {
            res[i] = j;
            j = j * nums[i];
        }
        j = 1;
        //当前下标右边的乘积
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= j;
            j *= nums[i];
        }

        return res;
    }
}
