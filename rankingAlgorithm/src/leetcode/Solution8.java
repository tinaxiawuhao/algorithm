package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wuhao
 * @desc 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * @date 2021-05-06 14:13:41
 */
public class Solution8 {
    public  void main(String[] args) {
        System.out.println(permutation("abc"));

    }

    List<String> list=new ArrayList<>();
    char[] chars;

    public  String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }
    public  void dfs(int number){
        //深度遍历到最后一层，保存结果并返回
        if(number==chars.length-1){
            list.add(String.valueOf(chars));
            return;
        }
        //判断是否重复
        HashSet<Character> set=new HashSet<>();
        for (int i = number; i <chars.length ; i++) {
            if(set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(i,number);
            dfs(number+1);
            swap(i,number);
        }

    }
    public void swap(int x,int y){
        char temp=chars[x];
        chars[x]=chars[y];
        chars[y]=temp;
    }

}
