package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 */
public class NextGreaterElementI_496 {
    public static void main(String[] args) {
        int nums1[] = {1, 3, 5, 2, 4};
        int nums2[] = {6, 5, 4, 3, 2, 1, 7};
        nextGreaterElementStack(nums1, nums2);
    }

    /**
     * 暴力法
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j; k < nums2.length; k++) {
                        if (nums1[i] < nums2[k]) {
                            result[i] = nums2[k];
                        } else {
                            result[i] = -1;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 栈
     */
    public static int[] nextGreaterElementStack(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
            System.out.println(res[i]);
        }
        return res;
    }
}
