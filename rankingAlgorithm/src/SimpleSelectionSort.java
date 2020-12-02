import java.util.Arrays;

/**
 * @author wuhao
 * @desc 简单选择排序
 * @date 2020-12-02 16:21:47
 */
public class SimpleSelectionSort {
    public static void main(String[] args) {
        int[] arr = {12, 32, 22, 7, 48, 3, 5, 6, 8, 24};
        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }


        }
        System.out.println(Arrays.toString(arr));
    }
}
