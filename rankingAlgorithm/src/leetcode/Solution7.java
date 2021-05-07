package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuhao
 * @desc 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为0、1或2
 * @date 2021-05-06 14:13:41
 */
public class Solution7 {
    public static void main(String[] args) {
        int[][] intA = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(intA));

    }

    public static int orangesRotting(int[][] grid) {
        //获取网格的边界
        int length = grid.length;
        int width = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //获取新鲜橘子数量和腐烂橘子坐标放入队列
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                //累加新鲜橘子数量
                if (grid[i][j] == 1) {
                    count++;
                }
                //将腐烂橘子放入队列
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        //记录搜索轮数和新鲜橘子剩余数
        int round = 0;
        //新鲜橘子和腐烂橘子不为空的情况
        while (count > 0 && !queue.isEmpty()) {
            //累加轮数
            round++;
            //获取队列数据，进行遍历
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                //获取腐烂橘子坐标
                int x = poll[0];
                int y = poll[1];
                //判断相邻的节点是否可以被感染
                //上节点
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    //将上节点感染腐烂
                    grid[x - 1][y] = 2;
                    //新鲜橘子减一
                    count--;
                    //将新感染的橘子放入队列
                    queue.add(new int[]{x - 1, y});
                }
                //下节点
                if (x + 1 < length && grid[x + 1][y] == 1) {
                    //将上节点感染腐烂
                    grid[x + 1][y] = 2;
                    //新鲜橘子减一
                    count--;
                    //将新感染的橘子放入队列
                    queue.add(new int[]{x + 1, y});
                }
                //左节点
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    //将上节点感染腐烂
                    grid[x][y - 1] = 2;
                    //新鲜橘子减一
                    count--;
                    //将新感染的橘子放入队列
                    queue.add(new int[]{x, y - 1});
                }
                //右节点
                if (y + 1 < width && grid[x][y + 1] == 1) {
                    //将上节点感染腐烂
                    grid[x][y + 1] = 2;
                    //新鲜橘子减一
                    count--;
                    //将新感染的橘子放入队列
                    queue.add(new int[]{x, y + 1});
                }
            }

        }
        //判断最后剩余的橘子数量
        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
}
