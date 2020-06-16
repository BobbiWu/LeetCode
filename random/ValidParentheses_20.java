package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Valid Parentheses
 * 有效的括号
 */
public class ValidParentheses_20 {
    private static HashMap<Character, Character> mappings;

    public static void main(String[] args) {
        String test ="{[()]}";
        initMap();
        System.out.println(isValid(test));
    }

    private static void initMap() {
        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
              char topElement = stack.empty()?'#':stack.pop();
              if (topElement!=mappings.get(c)){
                  return false;
              }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
