package leetcode;

/**
 * @author wuhao
 * @desc
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 *
 * 输入: 9
 * 输出: 3
 * 解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 *
 * 输入: 15
 * 输出: 4
 * 解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * 说明: 1 <= N <= 10 ^ 9
 * @date 2021-01-07 15:55:00
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(12));
    }
    public static int consecutiveNumbersSum(int N) {
        int result = 1;
        int sum = 1;
        //一个连续正整数即N本身，我们从2开始逐一判断，true则加1
        for (int i=2; (sum+=i)<=N; i++) {
            if ((N-sum)%i == 0) {
                result++;
            }
        }
        return result;
    }
}
