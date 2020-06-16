package leetcode;

/**
 * 面试题 64
 * <p>
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InterviewQuestions_64 {
    public static void main(String[] args) {
        System.out.println(sumNums(9));
    }

    /**
     * 解题思路：
     * 递归
     */
    public static int sumNums(int n) {
        boolean flag = n == 0 || (n += sumNums(n - 1)) > 0;
        return n;
    }
}
