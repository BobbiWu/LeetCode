package leetcode.recursion;

/**
 * 509. 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 ≤ N ≤ 30
 */
public class FibonacciNumber_509 {
    public static void main(String[] args) {
        System.out.println(fib2(3));
    }

    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    //循环
    public static int fib2(int N) {
        if (N < 1) {
            return N;
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        for (int i = 2; i <= N; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
