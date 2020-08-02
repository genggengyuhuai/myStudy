package algorithm.leetcode;

/**
 * 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t
 * 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。@author lihaoyu
 * @date 2020/5/7 2:03 下午
 */
public class Main572 {
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

    public boolean fun(TreeNode root, TreeNode node){
        if(root == null && node == null)  return true;
        if(!( root != null && node != null))return false;
        if(root.val != node.val) return false;
        boolean left = fun(root.left, node.left);
        if(!left) return false;
        boolean right = fun(root.right, node.right);
        if(!right) return false;
        return true;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(fun(s,t)) return true;
        if(s != null)
        return isSubtree(s.left, t) || isSubtree(s.right, t);
        return false;
    }
    public static void main(String[] args) {

    }
}
