package leetcode.random;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入
 */
public class ImplementStr_28 {
    public static void main(String[] args) {
        String haystack = "aaa";
        String needle = "a";
        System.out.println(strStr2(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        int hayL = haystack.length();
        int needL = needle.length();
        if (needL == 0) return 0;
        int lP = 0;
        //是否超过较短字符串短长度
        while (lP < hayL - needL + 1) {
            //只有长字符串的元素等于短字符串的第一个元素才进行比较
            while (lP < hayL - needL + 1 && haystack.charAt(lP) != needle.charAt(0)) ++lP;
            int sp = 0;
            int current = 0;//当前的比较下标
            while (sp < needL && lP < hayL && haystack.charAt(lP) == needle.charAt(sp)) {
                ++lP;
                ++sp;
                ++current;
            }
            if (current == needL) return lP - needL;
            //如果有元素不一样的时候
            lP = lP - current + 1;
        }
        return -1;
    }
}
