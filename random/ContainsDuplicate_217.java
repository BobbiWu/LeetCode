package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate_217 {
    public static void main(String[] args) {
//        int nums[] = {1, 2, 3, 4};
        int nums[] = {1, 2, 3, 1};
        System.out.println(containsDuplicate2(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : nums) {
            if (map.containsKey(value)) {
                return true;
            }else {
                map.put(value,value);
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int value : nums) {
           if (map.contains(value)){
               return true;
           }else {
               map.add(value);
           }
        }
        return false;
    }
}
