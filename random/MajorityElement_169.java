package leetcode;

/**
 * 169 多数元素
 */
public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums = {8,9,8,9,8};
        majorityElement(nums);
    }

    public static int majorityElement(int[] nums) {
        System.out.println(majorityEleme(nums, 0, nums.length - 1));
        return majorityEleme(nums, 0, nums.length - 1);
    }

    private static int majorityEleme(int[] nums, int lo, int li) {
        if (lo == li) {
            return nums[lo];
        }
        int mid = (li - lo) / 2 + lo;
        int left = majorityEleme(nums, lo, mid);
        int right = majorityEleme(nums, mid + 1, li);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, lo, li);
        int rightCount = countInRange(nums, right, lo, li);
        return leftCount > rightCount ? left : right;
    }

    private static int countInRange(int[] nums, int num, int lo, int li) {
        int count = 0;
        for (int i = lo; i <=li; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
