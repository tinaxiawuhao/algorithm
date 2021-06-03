package leetcode;

import java.util.Arrays;

/**
 * @author wuhao
 * @desc 1787. 使所有区间的异或结果为零
 * 给你一个整数数组 nums 和一个整数 k 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
 * <p>
 * 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0,3,0], k = 1
 * 输出：3
 * 解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * 输出：3
 * 解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * 输出：3
 * 解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 2000
 * 0 <= nums[i] < 210
 * @date 2021-05-25 14:13:41
 */
class Solution22 {
    public static void main(String[] args) {
        System.out.println(minChanges(new int[]{26,19,19,28,13,14,6,25,28,19,0,15,25,11}, 3));
    }

    public static String minChanges(int[] nums, int k) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            int result = 0;
            int number2 = 0;
            int min = Math.min(i + k, nums.length);
            for (int j = i; j < min; j++) {
                number2++;
                if (number2 == k && result != nums[min - 1]) {
                    nums[min - 1] = result;
                    number++;
                } else {
                    result ^= nums[j];
                }
            }
        }
        return Arrays.toString(nums);
    }

}