package leetcode;

public class SortAnArray_912 {
    public static void main(String[] args) {
        int nums[] = {5, 2, 3, 1};
        int[] ints = sortArray(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }

            }
        }
        return nums;
    }

}
