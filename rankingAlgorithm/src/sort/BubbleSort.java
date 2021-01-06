package sort;

import java.util.Arrays;

/**
 * @author wuhao
 * @desc 冒泡排序
 * @date 2020-12-02 16:34:57
 * 冒泡排序思路比较简单：
 * 将序列当中的左右元素，依次比较，保证右边的元素始终大于左边的元素；
 * （ 第一轮结束后，序列最后一个元素一定是当前序列的最大值；）
 * 对序列当中剩下的n-1个元素再次执行步骤1。
 * 对于长度为n的序列，一共需要执行n-1轮比较
 * （利用while循环可以减少执行次数）
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {12, 32, 22, 7, 48};
        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
