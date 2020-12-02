import java.util.Arrays;

/**
 * @author wuhao
 * @desc 直接插入排序
 * @date 2020-12-02 15:04:57
 */
public class DirectInsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 32, 22, 7, 48};
        insertSort(arr);
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
