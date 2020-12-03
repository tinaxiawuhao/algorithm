import java.util.Arrays;

/**
 * @author wuhao
 * @desc 快速排序
 * @date 2020-12-02 17:08:57
 * 快速排序的基本思想：挖坑填数+分治法
 * 从序列当中选择一个基准数(pivot)
 * 在这里我们选择序列当中第一个数为基准数
 * 将序列当中的所有数依次遍历，比基准数大的位于其右侧，比基准数小的位于其左侧
 * 重复步骤a.b，直到所有子集当中只有一个元素为止。
 * 用伪代码描述如下：
 * 1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
 * 2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
 * 3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
 * 4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 32, 22, 7, 48, 3, 35, 6, 8, 42};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = arr[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (arr[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (arr[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        // 将基准数放到中间的位置（基准数归位）
        arr[left] = arr[i];
        arr[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

}
