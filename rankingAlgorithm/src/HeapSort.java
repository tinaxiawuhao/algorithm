import java.util.Arrays;

/**
 * @author wuhao
 * @desc 堆排序
 * @date 2020-12-04 09:13:58
 * 堆排序可以按照以下步骤来完成：
 * 首先将序列构建称为大顶堆；
 * （这样满足了大顶堆那条性质：位于根节点的元素一定是当前序列的最大值）
 * 取出当前大顶堆的根节点，将其与序列末尾元素进行交换；
 * （此时：序列末尾的元素为已排序的最大值；由于交换了元素，当前位于根节点的堆并不一定满足大顶堆的性质）
 * 对交换后的n-1个序列元素进行调整，使其满足大顶堆的性质；
 * 重复2.3步骤，直至堆中只有1个元素为止
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {11, 44, 23, 67, 88, 65, 34, 48, 9, 12};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] a) {
        // 首先需要创建根堆
        for (int i = a.length / 2; i >= 0; i--) { // 从最后一个非终端结点开始，然后一次--
            HeapAdjust(a, i, a.length);
        }

        for (int i = a.length - 1; i > 0; --i) {// 这个循环是把最大值a[0]放到末尾 ，
            int temp = a[0];
            a[0] = a[i]; // 此时i代表最后一个元素
            a[i] = temp;
            HeapAdjust(a, 0, i );
        }
    }

    // 调整堆
    private static void HeapAdjust(int[] a, int parent, int m) {// parent代表当前 m代表最后
        int temp = a[parent]; // 先把a[parent]的值赋给temp保存起来
        for (int j = 2 * parent; j < m; j *= 2) {
            if (j+1 < m && a[j] < a[j + 1]) { // 判断是a[parent]大还是a[j + 1]大，如果a[j + 1]大 就++j，把j换成当前最大
                j++;
            }
            if (temp >= a[j]) { // 如果temp中比最大值还大，代表本身就是一个根堆，break
                break;// 如果大于，就代表当前为大跟对，退出
            }
            a[parent] = a[j];// 否则就把最大给[parent]
            parent = j;// 然后把最大下标给parent，继续循环,检查是否因为调整根堆而破坏了子树
        }
        a[parent] = temp;
    }

    /**
     * 创建堆，
     * @param arr 待排序列
     */
//    private static void heapSort(int[] arr) {
//        //创建堆
//        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
//            //从第一个非叶子结点从下至上，从右至左调整结构
//            adjustHeap(arr, i, arr.length);
//        }
//
//        //调整堆结构+交换堆顶元素与末尾元素
//        for (int i = arr.length - 1; i > 0; i--) {
//            //将堆顶元素与末尾元素进行交换
//            int temp = arr[i];
//            arr[i] = arr[0];
//            arr[0] = temp;
//
//            //重新对堆进行调整
//            adjustHeap(arr, 0, i);
//        }
//    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
//    private static void adjustHeap(int[] arr, int parent, int length) {
//        //将temp作为父节点
//        int temp = arr[parent];
//        //左孩子
//        int lChild = 2 * parent + 1;
//
//        while (lChild < length) {
//            //右孩子
//            int rChild = lChild + 1;
//            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
//            if (rChild < length && arr[lChild] < arr[rChild]) {
//                lChild++;
//            }
//
//            // 如果父结点的值已经大于孩子结点的值，则直接结束
//            if (temp >= arr[lChild]) {
//                break;
//            }
//
//            // 把孩子结点的值赋给父结点
//            arr[parent] = arr[lChild];
//
//            //选取孩子结点的左孩子结点,继续向下筛选
//            parent = lChild;
//            lChild = 2 * lChild + 1;
//        }
//        arr[parent] = temp;
//    }



}
