package leetcode.interview;


import java.util.Stack;

/**
 * 每日温度
 * <p>
 * 根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/iIQa4I
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {
    public static void main(String[] args) {//11421100
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    /**
     * 用栈来存储
     * 解题思路：
     * 根据题意，只要后面的温度比前面的温度高即可，并且越后面的温度越先比较，因此符合 栈的后入先出的特征
     * 所以我们可以通过栈来存储数组的下标，遇到温度大的时候用下标相减，就能得到天数。
     */


    private static int[] dailyTemperatures(int[] temperatures) {
        int[] ints = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int value = stack.pop();
                ints[value] = i - value;
            }
            stack.push(i);
        }
        return ints;
    }

    /**
     * 暴力法
     */
    private static int[] dailyTemperatures2(int[] temperatures) {
        int[] ints = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ints[i] = j - i;
                    break;
                }
            }
        }
        return ints;
    }
}
