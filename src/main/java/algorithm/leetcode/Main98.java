package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断是不是二叉树
 *
 * @author lihaoyu
 * @date 2020/5/5 16:31
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Main98 {

    //  中序遍历，大小判断
    private final List<Integer> list = new ArrayList<>();

    private void inOrderVisit(TreeNode root) {
        if (root == null) return;
        inOrderVisit(root.left);
        list.add(root.val);
        inOrderVisit(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        inOrderVisit(root);
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i - 1) >= list.get(i)) return false;
//        }
//        return true;
    }

    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
    }
}
