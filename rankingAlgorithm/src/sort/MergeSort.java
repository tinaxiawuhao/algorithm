package sort;

import java.util.Arrays;

/**
 * @author wuhao
 * @desc 归并排序
 * @date 2020-12-03 09:35:00
 * 归并排序是建立在归并操作上的一种有效的排序算法，该算法是采用0的一个典型的应用。它的基本操作是：将已有的子序列合并，达到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 * 归并排序其实要做两件事：
 * 分解----将序列每次折半拆分
 * 合并----将划分后的序列段两两排序合并
 * 因此，归并排序实际上就是两个操作，拆分+合并
 * 如何合并？
 * L[first...mid]为第一段，L[mid+1...last]为第二段，并且两端已经有序，现在我们要将两端合成达到L[first...last]并且也有序。
 * 首先依次从第一段与第二段中取出元素比较，将较小的元素赋值给temp[]
 * 重复执行上一步，当某一段赋值结束，则将另一段剩下的元素赋值给temp[]
 * 此时将temp[]中的元素复制给L[]，则得到的L[first...last]有序
 * 如何分解？
 * 在这里，我们采用递归的方法，首先将待排序列分成A,B两组；然后重复对A、B序列
 * 分组；直到分组后组内只有一个元素，此时我们认为组内所有元素有序，则分组结束。
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {11, 44, 23, 67, 88, 65, 34, 48, 9, 12};
        int[] tmp = new int[arr.length];    //新建一个临时数组存放
        mergeSort(arr, 0, arr.length - 1, tmp);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, tmp);
            mergeSort(arr, mid + 1, high, tmp);
            merge(arr, low, mid, high, tmp);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = 0;
        int j = low, k = mid + 1;
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }
        while (k <= high) {
            tmp[i++] = arr[k++];
        }
        for (int l = 0; l < i; l++) {
            arr[low+l] = tmp[l];
        }

    }
}
