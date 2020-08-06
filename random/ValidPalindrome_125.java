package leetcode.random;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPalindrome_125 {
    public static void main(String[] args) {

//        String str = "A man, a plan, a canal: Panama";
        String str = "race a car";

        System.out.println(isPalindrome(str));

    }

    public static boolean isPalindrome(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stringBuffer.append(Character.isLowerCase(c));
            }
        }
        int left = 0;
        int right = stringBuffer.length()- 1;
        while (left < right) {
            if (Character.isLowerCase(stringBuffer.charAt(left))!=Character.isLowerCase(stringBuffer.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

