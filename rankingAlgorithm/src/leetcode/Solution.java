package leetcode;

/**
 * @author wuhao
 * @desc 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围[0, 10^8]
 *
 * @date 2021-01-07 09:18:43
 */
public class Solution {
    public static void main(String[] args) {
        //1193，98368，98367，9973
        System.out.println(maximumSwap(9973));

    }
    public static int maximumSwap(int num) {
        //去除边界值
        if(num==0){
            return num;
        }
        //化为数组
        char[] chars = String.valueOf(num).toCharArray();
        //获取最大值
        int max=0;
        //交换地址
        int address=0;
        for (int i = 0; i < chars.length; i++) {
            char mid=chars[i];
            address=i;
            for (int j = i+1; j < chars.length; j++) {
                if(mid<=chars[j]){
                    max=j;
                    mid=chars[j];
                }
            }
            if(mid!=chars[i]){
                break;
            }

        }

        //交换位置
        if(max!=0&&address!=chars.length-1){
            char value=chars[address];
            chars[address]=chars[max];
            chars[max]=value;
        }

        return Integer.parseInt(String.valueOf(chars));
    }
}
