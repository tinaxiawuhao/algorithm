package sort;

import java.util.Arrays;

/**
 * @author wuhao
 * @desc 希尔排序
 * @date 2020-12-02 15:20:43
 * 希尔排序的算法思想：将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；每次将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。
 * 同样的：从上面的描述中我们可以发现：希尔排序的总体实现应该由三个循环完成：
 * 第一层循环：将gap依次折半，对序列进行分组，直到gap=1
 * 第二、三层循环：也即直接插入排序所需要的两次循环。具体描述见上。
 */
public class HillSort {
    public static void main(String[] args) {
        int[] arr = {12, 32, 22, 7, 48, 3, 5, 6, 8, 24};
        shellSort(arr);
    }

    private static void shellSort(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i - step; j >= 0 && arr[j] > temp; j -= step) {
                    arr[j + step] = arr[j];
                }
                arr[j + step] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
