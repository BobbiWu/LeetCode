package leetcode.interview;


import java.util.Stack;

/**
 * 后缀表达式
 * <p>
 * 后缀表达式是一种算术表达式，它的操作符在操作数的后面，输入一个用字符串数组表示的后缀表达式，
 * 请输出该后缀表达式的计算结果
 * <p>
 * ["2","1","3","*","+"]
 */
public class PostfixExpression {
    /**
     *解题思路：
     * 要先理解后缀表达式，后缀表达式把操作符都是放到最后面，知道了前面的操作数，但是不知道
     * 操作符，没有办法进行计算，因此我们可以先保存操作数，等读取到了操作数再进行操作
     *
     */
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "3", "*", "+"};
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int numOne = stack.pop();
                    int numTwo = stack.pop();
                    stack.push(calculate(numOne, numTwo, token));
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }

        }
        System.out.println(stack.peek());
    }

    private static int calculate(Integer numOne, Integer numTwo, String token) {
        switch (token) {
            case "+":
                return numOne + numTwo;
            case "-":
                return numOne - numTwo;
            case "*":
                return numOne * numTwo;
            case "/":
                return numOne / numTwo;
            default:
                return 0;

        }
    }
}
