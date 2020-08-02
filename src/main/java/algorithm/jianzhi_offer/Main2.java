package algorithm.jianzhi_offer;


/**
 * 前序遍历和中序遍历的结果，请重建出该二叉树
 * @author lihaoyu
 * @date 3/11/2020 9:08 AM
 */
public class Main2 {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode fun(int[] in, int[] post, int start_in, int end_post, int len){
        if(len <= 0) return null;
        TreeNode root = new TreeNode(post[end_post]);
        int index = 0;
        for(int i = start_in; i < start_in + len; i++){
            if(in[i] == root.val){
                index = i; break;
            }
        }
        int leftLen = index - start_in;
        int rightLen = len - leftLen - 1;
        root.left = fun(in, post, start_in, end_post-1-rightLen, leftLen);
        root.right = fun(in, post, index+1, end_post-1, rightLen);
        return root;
    }

    // 假设输入有效
    public TreeNode reConstructBinaryTree(int[] inorder, int[] postorder) {
      return fun(inorder,postorder, 0,postorder.length-1,inorder.length);
    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.reConstructBinaryTree(new int[]{2,1,3},new int[]{2,3,1});
    }
}
