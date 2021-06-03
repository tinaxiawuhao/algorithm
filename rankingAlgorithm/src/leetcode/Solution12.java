package leetcode;

/**
 * @author wuhao
 * @desc 1269. 停在原地的方案数
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 * <p>
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 * <p>
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 * @date 2021-05-13 14:13:41
 */
class Solution12 {
    public static void main(String[] args) {
        System.out.println(numWays(3, 2));
    }

    /*dp[i][j]=dp[i−1][j−1]+dp[i−1][j]+dp[i−1][j+1]*/
    public static int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps / 2 + 1);
        int[][] dp = new int[steps + 1][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        //return dp[steps][0];

        int min = Math.min(steps / 2 + 1, arrLen);
        int[][] result = new int[2][min + 2];
        result[0][1] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 1; j <= min; j++) {
                result[i & 1][j] = (((result[(i - 1) & 1][j - 1] % (1000000007)) + result[(i - 1) & 1][j]) % (1000000007) + result[(i - 1) & 1][j + 1]) % (1000000007);
            }
        }
        return result[steps & 1][1];
    }
}