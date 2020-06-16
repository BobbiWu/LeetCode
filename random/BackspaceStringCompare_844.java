package leetcode;

import java.util.Stack;

/**
 * Backspace String Compare
 * 比较含退格的字符串
 */
public class BackspaceStringCompare_844 {

    public static void main(String[] args) {
        String T = "ab#c";
        String S = "ad#c";
        System.out.println( backspaceCompare(T, S));
    }

    /**
     * 解题思路： 遍历字符串，如果字符串不是 # 就进栈，如果是 # 就出栈（相当于回退）
     *
     */
    public static boolean backspaceCompare(String s, String t) {
     return backString(s).equals(backString(t));
    }

    private static String backString(String s) {
        Stack<Character> mStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                mStack.push(c);
            } else if (!mStack.isEmpty()) {
                mStack.pop();
            }
        }
        return mStack.toString();
    }

}
