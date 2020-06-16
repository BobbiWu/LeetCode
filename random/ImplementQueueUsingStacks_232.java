package leetcode;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class ImplementQueueUsingStacks_232 {
    private Stack<Integer> mPushStack;
    private Stack<Integer> mPopStack;

    /**
     *解题思路：维护两个栈，当元素 push 之后 ，我们通过 pop ，push 到另一个栈来交换元素当顺序
     */
    public static void main(String[] args) {
        ImplementQueueUsingStacks_232 stack = new ImplementQueueUsingStacks_232();
        // todo
    }

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks_232() {
        mPopStack = new Stack<>();
        mPushStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        mPopStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        exchange();
        if (!mPopStack.isEmpty()) {
            mPushStack.push(mPopStack.pop());
            return mPushStack.pop();
        }
        throw new RuntimeException("队列里没有元素");
    }

    /**
     * Get the front element.
     */
    public int peek() {
        exchange();
        if (!mPushStack.isEmpty()) {
            return mPushStack.peek();
        }
        throw new RuntimeException("队列里没有元素");
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
          return mPushStack.isEmpty();
    }

    private void exchange() {
        if (mPushStack.isEmpty()) {
            while (!mPopStack.isEmpty()) {
                mPushStack.push(mPopStack.pop());
            }
        }
    }
}
