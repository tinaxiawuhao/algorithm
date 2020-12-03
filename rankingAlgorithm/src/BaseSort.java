import java.util.Arrays;

/**
 * @author wuhao
 * @desc 基数排序
 * @date 2020-12-03 09:58:32
 * 基数排序：通过序列中各个元素的值，对排序的N个元素进行若干趟的“分配”与“收集”来实现排序。
 * 分配：我们将L[i]中的元素取出，首先确定其个位上的数字，根据该数字分配到与之序号相同的桶中
 * 收集：当序列中所有的元素都分配到对应的桶中，再按照顺序依次将桶中的元素收集形成新的一个待排序列L[ ]
 * 对新形成的序列L[]重复执行分配和收集元素中的十位、百位...直到分配完该序列中的最高位，则排序结束
 * 根据上述“基数排序”的展示，我们可以清楚的看到整个实现的过程
 */
public class BaseSort {
    public static void main(String[] args) {
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};

        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        //待排序列最大值
        int max = arr[0];
        int exp;//指数
        //计算最大值
        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }
        //从个位开始，对数组进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            //存储待排元素的临时数组
            int[] temp = new int[arr.length];
            //分桶个数
            int[] buckets = new int[10];

            //将数据出现的次数存储在buckets中
            for (int value : arr) {
                //(value / exp) % 10 :value的最底位(个位)
                buckets[(value / exp) % 10]++;
            }

            //更改buckets[i]，
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据存储到临时数组temp中
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
                buckets[(arr[i] / exp) % 10]--;
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }

    }
}
