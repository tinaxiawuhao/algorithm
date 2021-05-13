package leetcode;

import java.util.Arrays;

/**
 * 给你两个整数m和k，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值。
 * <p>
 * MK 平均值按照如下步骤计算：
 * <p>
 * 如果数据流中的整数少于 m个，MK 平均值为 -1，否则将数据流中最后 m个元素拷贝到一个独立的容器中。
 * 从这个容器中删除最小的 k个数和最大的 k个数。
 * 计算剩余元素的平均值，并 向下取整到最近的整数。
 * 请你实现MKAverage类：
 * <p>
 * MKAverage(int m, int k)用一个空的数据流和两个整数 m和 k初始化MKAverage对象。
 * void addElement(int num)往数据流中插入一个新的元素num。
 * int calculateMKAverage()对当前的数据流计算并返回 MK 平均数，结果需 向下取整到最近的整数 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", "calculateMKAverage", "addElement", "addElement", "addElement", "calculateMKAverage"]
 * [[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
 * 输出：
 * [null, null, null, -1, null, 3, null, null, null, 5]
 * <p>
 * 解释：
 * MKAverage obj = new MKAverage(3, 1);
 * obj.addElement(3);        // 当前元素为 [3]
 * obj.addElement(1);        // 当前元素为 [3,1]
 * obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
 * obj.addElement(10);       // 当前元素为 [3,1,10]
 * obj.calculateMKAverage(); // 最后 3 个元素为 [3,1,10]
 * // 删除最小以及最大的 1 个元素后，容器为 [3]
 * // [3] 的平均值等于 3/1 = 3 ，故返回 3
 * obj.addElement(5);        // 当前元素为 [3,1,10,5]
 * obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
 * obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
 * obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]
 * // 删除最小以及最大的 1 个元素后，容器为 [5]
 * // [5] 的平均值等于 5/1 = 5 ，故返回 5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= m <= 10^5
 * 1 <= k*2 < m
 * 1 <= num <= 10^5
 * addElement 与calculateMKAverage总操作次数不超过 10^5 次。
 */
class MKAverage {
    private int[] arr;
    private int M;
    private int K;
    private int size;
    private int len;

    public MKAverage(int m, int k) {
        this.M = m;
        this.K = k;
        this.len=m;
        this.size=0;
        this.arr = new int[m];
    }

    public void addElement(int num) {
        if(size >= len) {
            arr = Arrays.copyOf(arr, 2 * len);
            len = arr.length;
        }
        arr[size ++] = num;
    }

    public int calculateMKAverage() {
        if(size < M){
            return -1;
        }
        int[] copyArr = Arrays.copyOfRange(arr, size - M, size);
        Arrays.sort(copyArr);
        int[] newArr = Arrays.copyOfRange(copyArr, K, copyArr.length - K);
        return avg(newArr);
    }

    private int avg(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return (int)(res / arr.length);
    }

    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);        // 当前元素为 [3]
        obj.addElement(1);        // 当前元素为 [3,1]
        System.out.println(obj.calculateMKAverage()); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
        obj.addElement(10);       // 当前元素为 [3,1,10]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [3,1,10]
        // 删除最小以及最大的 1 个元素后，容器为 [3]
        // [3] 的平均值等于 3/1 = 3 ，故返回 3
        obj.addElement(5);        // 当前元素为 [3,1,10,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage()); // 最后 3 个元素为 [5,5,5]
        // 删除最小以及最大的 1 个元素后，容器为 [5]
        // [5] 的平均值等于 5/1 = 5 ，故返回 5
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */