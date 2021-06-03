package leetcode;

/**
 * @author wuhao
 * @desc 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 * @date 2021-05-13 14:13:41
 */
class Solution16 {
    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }

    public static int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = m * (1 << (n - 1));
        for (int j = 1; j < n; j++) {
            int number=0;
            for (int i = 0; i < m; i++) {
                if(grid[i][0]==1){
                    number+=grid[i][j];
                }else{
                    number+=(1-grid[i][j]);
                }
            }
            int k=Math.max(m-number,number);
            result+=k*(1<<(n-j-1));
        }
        return result;
    }
}