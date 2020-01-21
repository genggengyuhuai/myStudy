package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * @author lihaoyu
 * @date 2020/1/21 21:41
 */

public class Main145 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        list1.addLast(root);
        while(!list1.isEmpty()){
            TreeNode temp = list1.pollFirst();
            list2.addLast(temp);
            if(temp.right != null) list1.addLast(temp.right);
            if(temp.left != null) list1.addLast(temp.left);
        }
        while(!list2.isEmpty()){
            res.add(list2.pollLast().val);
        }
        return res;
    }


}
