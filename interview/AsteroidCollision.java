package leetcode.interview;


import java.util.Stack;

/**
 * 小行星碰撞
 * <p>
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/XagZNi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 */
public class AsteroidCollision {
    public static void main(String[] args) {

    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (Integer asteroid : asteroids) {
            //不同方向，质量大小不一样
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                stack.pop();
            }
            if (!stack.isEmpty() && asteroid < 0 && stack.peek() == -asteroid) {
                //相同质量，不同方向
                stack.pop();
            } else if (stack.isEmpty() || asteroid > 0 || stack.peek() < 0) {
                stack.push(asteroid);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
