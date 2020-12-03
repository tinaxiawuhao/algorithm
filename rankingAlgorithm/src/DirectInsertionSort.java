import java.util.Arrays;

/**
 * @author wuhao
 * @desc 直接插入排序
 * @date 2020-12-02 15:04:57
 * 直接插入排序的核心思想就是：将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过。
 * 因此，从上面的描述中我们可以发现，直接插入排序可以用两个循环完成：
 * 第一层循环：遍历待比较的所有数组元素
 * 第二层循环：将本轮选择的元素(selected)与已经排好序的元素(ordered)相比较。
 * 如果：selected > ordered，那么将二者交换
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
