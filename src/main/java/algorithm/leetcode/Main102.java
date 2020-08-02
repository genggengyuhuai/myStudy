package algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层序遍历
 * @author lihaoyu
 * @date 2020/5/13 10:00 上午
 */
public class Main102 {

    private final List<List<Integer>> res = new ArrayList<>();
    private void fun(TreeNode root, int depth){
        if(root == null) return;
        if(res.size() <= depth) res.add(new ArrayList<>());
        res.get(depth).add(root.val);
        fun(root.left, depth+1);
        fun(root.right, depth+1);
    }

    // 递归写法
    public List<List<Integer>> levelOrder(TreeNode root) {
        fun(root, 0);
        return res;
    }

    public static void main(String[] args) {

    }
}
