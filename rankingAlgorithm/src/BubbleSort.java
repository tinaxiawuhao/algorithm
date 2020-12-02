import java.util.Arrays;

/**
 * @author wuhao
 * @desc 冒泡排序
 * @date 2020-12-02 16:34:57
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
