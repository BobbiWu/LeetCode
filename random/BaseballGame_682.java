package leetcode;

import java.util.Stack;

/**
 * Baseball Game
 * 棒球比赛
 */
public class BaseballGame_682 {

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));

    }

    /**
     *解题思路：
     * 用栈来存取数据，如果没有操作符号的 直接 入栈， C 的是删除栈顶元素，D 是栈顶元素的双倍再入栈
     * 需要注意的就是 + ，这个是最后两个回合分数的和，那么就需要知道 栈顶元素和栈顶的第二个元素，通过先让栈顶元素 先出栈 pop()，
     * 在获取栈顶顶第二个元素 peek()，最后在把它们相加，然后依次入栈。
     */
    public static int calPoints(String[] ops) {
        Stack<Integer> mStack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            String val = ops[i];
            switch (val) {
                case "C":
                    if (!mStack.isEmpty()) {
                        mStack.pop();
                    }
                    break;
                case "D":
                    int value = (mStack.peek()) * 2;
                    mStack.push(value);
                    break;
                case "+":
                    int topValue = mStack.pop();
                    int secondValue = mStack.peek();
                    mStack.push(topValue);
                    mStack.push(topValue + secondValue);
                    break;
                default:
                    mStack.push(Integer.valueOf(val));
                    break;
            }
        }

        for (int value : mStack) {
            sum += value;
        }
        return sum;
    }
}
