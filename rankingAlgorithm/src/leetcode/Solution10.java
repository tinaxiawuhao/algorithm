package leetcode;

/**
 * @author wuhao
 * @desc 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * <p>
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * <p>
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 * <p>
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 * @date 2021-05-06 14:13:41
 */
class Solution10 {
    public int[] decode(int[] encoded) {
        //获取perm异或总计
        int total = 0;
        for (int i = 0, j = 1; i <= encoded.length + 1; i++,j+=2) {
            total ^= i;
        }
        int add = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            add ^= encoded[i];
        }
        //获取perm[0]
        int[] perm = new int[encoded.length + 1];
        perm[0] = total ^ add;
        //遍历获取perm
        for (int i = 0; i < encoded.length; i++) {
            perm[i + 1] = encoded[i] ^ perm[i];
        }
        return perm;
    }
}
