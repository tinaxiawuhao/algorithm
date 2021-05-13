package leetcode;

import java.util.*;

/**
 * @author wuhao
 * @desc 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
 * <p>
 * <p>
 * <p>
 * 举个例子，如上图所示，给定一棵叶值序列为(6, 7, 4, 9, 8)的树。
 * <p>
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
 * <p>
 * 如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * 示例 5：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的两棵树可能会有1到 200个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 * @date 2021-05-06 14:13:41
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution9 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (Objects.nonNull(root1)) {
            dfs(root1,list1);
        }
        if (Objects.nonNull(root2)) {
            dfs(root2,list2);
        }
        return list1.equals(list2);
    }

    public void dfs(TreeNode root, List<Integer> list) {

        if (Objects.isNull(root.left)&& Objects.isNull(root.right)){
            list.add(root.val);
        }else{
            if(Objects.nonNull(root.left)){
                dfs(root.left,list);
            }
            if(Objects.nonNull(root.right)){
                dfs(root.right,list);
            }
        }

    }

    //广度优先遍历
    public void bfs(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); //首先将根节点存入队列
        //当队列里有值时，每次取出队首的node打印，打印之后判断node是否有子节点，若有，则将子节点加入队列
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();//取出队首元素并打印
            System.out.print(node.val);
            if(node.left != null){ //如果有左子节点，则将其存入队列
                queue.offer(node.left);
            }
            if(node.right != null){ //如果有右子节点，则将其存入队列
                queue.offer(node.right);
            }
        }
    }
    //深度优先遍历（递归）
    public void dfs(TreeNode node,List<List<Integer>> rst,List<Integer> list){
        if(node == null) return;
        if(node.left == null && node.right == null){
            list.add(node.val);
            /* 这里将list存入rst中时，不能直接将list存入，而是通过新建一个list来实现，
             * 因为如果直接用list的话，后面remove的时候也会将其最后一个存的节点删掉
             * */
            rst.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        list.add(node.val);
        dfs(node.left,rst,list);
        dfs(node.right,rst,list);
        list.remove(list.size()-1);
    }

    //深度优先遍历(非递归)
    public void dfs(TreeNode node){
        if(node == null) return;
        Stack<TreeNode> stack=new Stack<>();
        //入栈
        stack.push(node);
        while (!stack.empty()){
            TreeNode pop = stack.pop();
            if(Objects.nonNull(pop.right)){
                stack.push(pop.right);
            }
            if(Objects.nonNull(pop.left)){
                stack.push(pop.left);
            }
        }

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}