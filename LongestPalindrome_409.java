package leetcode;

/**
 * 最长回文
 */
public class LongestPalindrome_409 {
    public static void main(String[] args) {
        String str = "abccccdd";
//        String str = "ccc";
//        String str = "ccd";
//        String str = "aAaAaAaAa";
        longestPalindrome(str);
    }

    public static int longestPalindrome(String str) {
        int[] words = new int[58];
        for (char c : str.toCharArray()) {
            words[c - 'A'] += 1;
        }
        int length = 0;
        for (int i : words) {
            if (i != 0 && i % 2 == 0) {
                length += i;
            } else if (i != 1 && i % 2 == 1) {
                length += i - 1;
            }
        }
        return length < str.length() ? length + 1 : length;
    }

    public static int longestPalindrome1(String s) {
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x : cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }
}
