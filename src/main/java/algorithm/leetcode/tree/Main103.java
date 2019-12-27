package algorithm.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
  103. 二叉树的锯齿形层次遍历
 * @author lihaoyu
 * @date 2019/12/27 18:33
 */
public class Main103 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        boolean flag = false;
        LinkedList<TreeNode> tempNode = new LinkedList<>();
        tempNode.addLast(root);
        while(!tempNode.isEmpty()){
            List<Integer> tempInt = new ArrayList<>();
            int len = tempNode.size();
            for(int i = 0; i < len; i++){
                TreeNode node = tempNode.pollFirst();
                tempInt.add(node.val);
                if(node.left != null) tempNode.addLast(node.left);
                if(node.right != null) tempNode.addLast(node.right);
            }
            if(flag) Collections.reverse(tempInt);
            res.add(tempInt);
            flag = !flag;
        }
        return res;
    }
}
