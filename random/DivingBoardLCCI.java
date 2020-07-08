package leetcode.random;

import java.util.ArrayList;

/**
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 */
public class DivingBoardLCCI {
    public static void main(String[] args) {
        int shorter = 1;
        int longer = 1;
        int k = 0;
        divingBoard(shorter, longer, k);
    }

    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] lengths = new int[k + 1];
        for (int i = 0; i <=k; i++) {
            lengths[i] = (shorter * i + longer * (k - i));
        }
        return lengths;
    }

}
