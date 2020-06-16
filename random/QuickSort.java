package leetcode;

public class QuickSort {
    public static void main(String[] args) {
        int ints[] = {5, 0, 11, 88, 99, 3, 4, 9, 8};
        int[] sort = quickSort(ints, 0, ints.length - 1);
        for (int value : sort) {
            System.out.println(value);
        }
    }

    /**
     * 快排思路：
     * 1.先找到一个参照对象，数组里任意一个数都可以
     * 2.然后循环数组让小于 参照对象的 排到左边，让大于参照对象的排右边
     */
    public static int[] quickSort(int[] a, int begin, int end) {
        //递归的终止条件
        if (end <= begin) return a;
        //得到参照对象
        int partition = partition(a, begin, end);
        //递归左右两边，让他们自己去排序
        quickSort(a, begin, partition - 1);
        quickSort(a, partition + 1, end);
        return a;
    }

    //获取参照元素
    private static int partition(int[] a, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            //将小于 end 的元素放到左边
            if (a[i] < a[pivot]) {
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        //将 end 元素，放到小于它的元素后面的位置，例如 1，2，3，end,...
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }
}

