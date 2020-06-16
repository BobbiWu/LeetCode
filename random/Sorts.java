package leetcode;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

/**
 * 常见三个排序
 */
public class Sorts {
    public static void main(String[] args) {
        int range[] = {4, 5, 1, 2, 3, 6};
//        int[] sort = sort(range);
//        printArray(insertSort(range));
        printArray(selectSort(range));
    }

    /**
     * 冒泡排序
     */
    private static int[] sort(int[] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length - i - 1; j++) {
                if (n[j] > n[j + 1]) {
                    int temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
            }
        }
        return n;
    }

    /**
     * 插入排序:分 已排序部分，非排序部分
     */
    private static int[] insertSort(int[] n) {
        for (int i = 1; i < n.length; i++) {
            int temp = n[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (n[j] > temp) {
                    n[j + 1] = n[j];
                } else {
                    break;
                }
            }
            n[j + 1] = temp;
        }
        return n;
    }

    /**
     * 选择排序:也分已排序区间和未排序区间。但是选择排序每次会从未排序区间中找到最小的元素
     * 将其放到已排序区间的末尾
     */
    private static int[] selectSort(int[] n) {
        for (int i = 0; i < n.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= n.length - 1; j++) {
                if (n[j] < n[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = n[i];
                n[i] = n[minIndex];
                n[minIndex] = temp;
            }
        }
        return n;
    }

    private static void printArray(int[] n) {
        for (int item : n) {
            System.out.print(item + "   ");
        }
    }
}
