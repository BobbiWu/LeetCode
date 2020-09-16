package leetcode.divide_conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParentheses_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    /**
     * 解题思路：判断左右括号是否相等切等n
     */
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    private static void generate(int left, int right, int n, String str, ArrayList<String> list) {
        //左括号和右括号都分配完
        if (left == n && right == n) {
            list.add(str);
            return;
        }
        //如果左括号没有分配完
        if (left < n) {
            generate(left + 1, right, n, str + "(", list);
        }
        //如果右括号没有分配完
        if (left > right) {
            generate( +left, right+1, n, str + ")", list);
        }

    }
}
