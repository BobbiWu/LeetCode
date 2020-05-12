package leetcode;

/**
 * 旋转数组 189
 */
public class RotateArray_189 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
    }

    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = last;
                last = temp;
            }
        }
    }
}
