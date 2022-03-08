package leetcode.interview;


import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 *
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按照从大到小的顺序排序，只允许申购一个栈，除此之外，可申请新的变量
 * 但不能申请额外的数据结构
 */
public class SortStackByStack {
    public static void main(String[] args) {

    }

    /**
     * 解题思路：
     * 申请多一个栈用，让其从顶到底 由小到大排序，最后再全部取出存入原来的栈
     * @param stack
     */
    private static void sortStack(Stack<Integer> stack) {
        Stack<Integer> newStack = new Stack<>();
        while (!stack.isEmpty()) {
            int value = stack.pop();
            while (!newStack.isEmpty() && newStack.peek() < value) {
                stack.push(newStack.pop());
            }
            newStack.push(value);
        }

        while (!newStack.isEmpty()){
            stack.push(newStack.pop());
        }
    }
}
