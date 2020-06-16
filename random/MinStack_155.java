package leetcode;

import java.util.Stack;

/**
 * Min Stack
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素
 * <p>
 * 来源：力扣（LeetCode）
 */
public class MinStack_155 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /**
     *解题思路：用两个栈，一个是数据栈，一个是最小元素的栈，当入栈的元素是最小到时候就进栈
     */
    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();
        minStack.push(1);
        minStack.push(4);
        minStack.push(3);
        minStack.push(5);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }


    public MinStack_155() {
        dataStack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int dataPop = dataStack.pop();
        if (dataPop == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
