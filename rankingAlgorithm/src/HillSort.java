import java.util.Arrays;

/**
 * @author wuhao
 * @desc 希尔排序
 * @date 2020-12-02 15:20:43
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
