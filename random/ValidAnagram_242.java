package leetcode.random;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidAnagram_242 {
    public static void main(String[] args) {
        String s = "rat";
        String t="car";
        System.out.println(isAnagram(s,t));
    }

    /**
     * 用哈希表来判断
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i=0;i<t.length();i++){
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }else {
                map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
            }
        }
        for (int value :map.values()){
            if (value>=1){
                return false;
            }
        }
        return true;
    }
}
