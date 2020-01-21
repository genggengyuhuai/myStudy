package algorithm.leetcode.tree;

/**
 * 236. 二叉树的最近公共祖先
 * @author lihaoyu
 * @date 2020/1/21 21:57
 */
public class Main236 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
         TreeNode res1 = lowestCommonAncestor(root.left,p,q);
         TreeNode res2 = lowestCommonAncestor(root.right,p,q);
        if(res1 == null) return res2;
        if(res2 == null) return res1;
        return root;
    }

}
