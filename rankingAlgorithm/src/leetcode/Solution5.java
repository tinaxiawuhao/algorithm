package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuhao
 * @desc 在数组中找到 2 个数之和等于给定值的数字，结果返回 2 个数字在数组中的下标
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 *
 * @date 2021-02-26 17:11:21
 */
public class Solution5 {
    public static void main(String[] args) {
        addTarget(new int[]{3,2,1,1,4,5,6,4,2,1,9},6);

    }

    public static void addTarget(int[] nums,int target) {
        Map map=new HashMap();
        for (int i = 0; i < nums.length ; i++) {
            int number=target-nums[i];
            if(map.get(number)!=null){
                System.out.print(i);
                System.out.print(":");
                System.out.println(map.get(number));
            }else {
                map.put(nums[i],i);
            }
        }
    }
}
