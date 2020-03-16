package leetcode;

/**
 * 字符串压缩
 */
public class CompressStringLCCI {
    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compressString(str));
    }

    /**
     *解题思路，用双指针来比较，然后统计重复的字符
     */
    public static String compressString(String str) {
        int length = str.length();
        if (length <= 2) {
            return str;
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < length) {
            int j = i;
            //如果字符串相同，就统计次数
            while (j < length && str.charAt(i) == str.charAt(j)) {
                j++;
            }
            stringBuilder.append(str.charAt(i));
            stringBuilder.append(j - i);
            i = j;
        }
        String targetStr = stringBuilder.toString();
        if (targetStr.length() < length) {
            return targetStr;
        } else {
            return str;
        }
    }
}
