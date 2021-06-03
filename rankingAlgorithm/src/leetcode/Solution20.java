package leetcode;

/**
 * @author wuhao
 * @desc 664. 奇怪的打印机
 * 有台奇怪的打印机有以下两个特殊要求：
 * <p>
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 * 示例 2：
 * <p>
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 * @date 2021-05-19 14:13:41
 */
class Solution20 {
    public static void main(String[] args) {
        System.out.println(strangePrinter("wedfghsdf"));
    }

    public static int strangePrinter(String s) {
        int n = s.length();
        int[][] result = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            result[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    result[i][j] = result[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, result[i][k] + result[k + 1][j]);
                    }
                    result[i][j] = minn;
                }
            }

        }
        return result[0][n-1];
    }

}