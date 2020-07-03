package leetcode.random;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 */
public class FirstUniqueCharacterInAString_387 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int j = 0; j < n; j++) {
            if (map.get(s.charAt(j)) == 1) {
                return j;
            }
        }

        return -1;
    }
}
