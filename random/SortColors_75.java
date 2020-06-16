package leetcode;

public class SortColors_75 {
    public static void main(String[] args) {
        int nums[] = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);
        }
    }

    private static void sortColors(int[] nums) {
        int size = nums.length;
        if (size < 2) {
            return;
        }
        //第一个区间
        int firstSection = 0;
        //第三个区间
        int thirdSection = size;
        //索引
        int i = 0;
        while (i < thirdSection) {
            if (nums[i] == 0) {
                swap(nums, i, firstSection);
                firstSection++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                thirdSection--;
                swap(nums, i, thirdSection);
            }
        }
    }


    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
