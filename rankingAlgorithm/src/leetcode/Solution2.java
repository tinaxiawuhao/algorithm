package leetcode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wuhao
 * @desc 给你一个整数数组 nums 和一个整数 k 。
 *
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *
 * 返回你可以对数组执行的最大操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= 10^9
 * @date 2021-01-07 14:03:28
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3,5,6,3,3,2,1},6));
    }

    public static int maxOperations(int[] nums, int k) {
        AtomicInteger result = new AtomicInteger();
        //排序
        Arrays.sort(nums);
        //头尾指针
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (k == sum) {//刚好相等。两个指针都往中间移动
                result.addAndGet(1);
                i++;
                j--;
            } else if (k > sum) {//两数之和太小，左指针右移，让和变大
                i++;
            } else {//两数之和太大，右指针左移，让和变小
                j--;
            }
        }
        return result.get();
//        Map<Integer,Integer> map=new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer value = map.get(k - nums[i]);
//            if(Objects.isNull(value)){
//                map.put(k - nums[i],1);
//            }else{
//                map.put(k - nums[i],value+1);
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            Integer value = map.get(nums[i]);
//            if (Objects.nonNull(value)&&value!=0){
//                map.put(nums[i],value-1);
//                result.addAndGet(1);
//            }
//        }
//        return result.get()/2;
    }
}
