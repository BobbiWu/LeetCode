package leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        moveZeroes2(nums);
    }

    /**
     * 两次遍历
     * 思路：
     * 第一次遍历将非0的都往前面移动，第二次遍历将剩下都位置都赋值为0
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int k = j; k < nums.length; ++k) {
            nums[k] = 0;
        }
    }

    /**
     * 一次遍历
     * 快排思想
     */
    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        for (int value:nums){
            System.out.println(value);
        }
    }
}
