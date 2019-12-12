package algorithm.leetcode.tree;


/**
 * 二叉树的最小深度
 * 用的递归，不如层序
 *  @author lihaoyu
 * @date 2019/12/12 16:09
 */
public class Main111 {
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

    private static int fun(TreeNode root){
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right != null){
            return 1 + Math.min(fun(root.left), fun(root.right));
        }
        if(root.left == null)return 1+fun(root.right);
        return 1+fun(root.left);
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        else return fun(root);
    }


    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2,null,node9);
        TreeNode node3 = new TreeNode(3,node5,node4);
        TreeNode node1 = new TreeNode(1,node3, node2);
        System.out.println(fun(node1));
    }
}
