package leetcode.array_linked;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class MergeSortedArray_88 {
    public static void main(String[] args) {
//        int nums1[] = {1, 2, 3, 0, 0, 0};
//        int nums2[] = {2, 5, 6};
//        int m = 3;
//        int n = 3;
        int nums1[] = {2,0};
        int nums2[] = {1};
        int m = 1;
        int n = 1;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copy_nums1 = new int[m];
        System.arraycopy(nums1, 0, copy_nums1, 0, m);
        int num1 = 0;
        int num2 = 0;
        int i = 0;
        while (num1 < m && num2 < n) {
            if (copy_nums1[num1] < nums2[num2]) {
                nums1[i] = copy_nums1[num1];
                num1++;
            } else {
                nums1[i] = nums2[num2];
                num2++;
            }
            i++;
        }
        //如果数组还有没有算完的，拷贝过来
        if (num1 < m) {
            System.arraycopy(copy_nums1, num1, nums1, i, m - num1);
        }
        if (num2 < n) {
            System.arraycopy(nums2, num2, nums1, i, n - num2);
        }
        for (int value : nums1) {
            System.out.println(value);
        }
    }
}

