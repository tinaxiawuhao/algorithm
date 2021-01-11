package leetcode;

/**
 * @author wuhao
 * @desc 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 *
 *
 * 示例1：
 *
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例2：
 *
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 *
 * @date 2021-01-07 09:18:43
 */
public class Solution4 {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{3,2,1,1,4,3,3}));

    }
    public static int candy(int[] ratings) {
        int[] candys=new int[ratings.length];
        int count=0;
        for (int i = 0; i < ratings.length; i++) {
            if(i!=0&&i==ratings.length-1){
                if(ratings[i]>ratings[i-1]){
                    candys[i]=candys[i-1]+1;
                }
            }
            if(i<ratings.length-1){
                if(i!=0){
                    if(ratings[i]>ratings[i-1]){
                        candys[i]=candys[i-1]+1;
                    }
                }
                int data=0;
                for (int j = i; j < ratings.length-1 &&  ratings[j]>ratings[j+1]; j++) {
                    data++;
                    if(data>candys[i]){
                        candys[i]=data;
                    }
                }

            }

        }
        for (int i = 0; i < candys.length; i++) {
            count+=candys[i];
        }
        return count+ratings.length;

    }
}
