package algorithm.leetcode.bytedance.linkedList_tree;

/**
 * 二叉树的最近公共祖先
 * @author lihaoyu
 * @date 2020/7/28 12:17 AM
 */
public class Main8 {

      private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;
        TreeNode par1 = lowestCommonAncestor(root.left,p,q);
        TreeNode par2 = lowestCommonAncestor(root.right, p,q);
        if(par1 != null && par2 != null) return root;
        return par1 == null ? par2 : par1;
    }


    public static void main(String[] args) {

    }
}
