package interview.baidu;

import java.util.Arrays;

/**
 *
 * 给定一棵普通树，共有 n 个节点，每个节点有权值，要找一条最长的路径 (u,v)
 * 使得从 u 沿着唯一路径走到 v 的途中，权值总是递增。
 * n 小于 10的5次方
 * 没说路径的定义，而且不是二叉树，好像要用图来做
 * @author lihaoyu
 * @date 3/29/2020 8:10 PM
 */
public class Main3 {

    private static int maxResLen = 1;

    private static class Res{
        // 以当前节点为根节点的  最长递增和递减路径长
        int incLen;
        int decLen;

        public Res(int incLen, int decLen) {
            this.incLen = incLen;
            this.decLen = decLen;
        }
    }
    private static class Node{
        // key 都大于 0
       int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    // 返回的是单边的最长递增和递减路径的长度
    private static Res singleEdgeIncreaseOrDecrease(Node root){
        if(root == null) return new Res(0,0);
        if(root.right == null && root.left == null) return new Res(1,1);
        Res left = singleEdgeIncreaseOrDecrease(root.left);
        Res right = singleEdgeIncreaseOrDecrease(root.right);
        Res res;
        // 左右子树有空的
        if(root.left == null){
            if(root.key >= root.right.key){
                res =  new Res(right.incLen+1,1);
            }else {
                res =  new Res(1, right.decLen + 1);
            }
            maxResLen = Math.max(maxResLen, Math.max(res.decLen, res.incLen));
            return res;
        }
        if(root.right == null){
            if(root.key >= root.left.key){
                res = new Res(left.incLen+1,1);
            }else {
                res =  new Res(1, left.decLen + 1);
            }
            maxResLen = Math.max(maxResLen, Math.max(res.decLen, res.incLen));
            return res;
        }
        // 左右子树都不为空
        int max = Math.max(root.left.key, root.right.key);
        int min = Math.min(root.left.key, root.right.key);
        // 比左右子树都小
        if(root.key < min){
            res =  new Res(1, left.decLen > right.decLen ? left.decLen + 1 : right.decLen + 1);
            maxResLen = Math.max(maxResLen, Math.max(res.decLen, res.decLen) + 1);
            return res;
        }else if(root.key > max){
            res =  new Res(left.incLen > right.incLen ? left.incLen + 1: right.incLen + 1, 1);
            maxResLen = Math.max(maxResLen, Math.max(res.incLen, res.incLen) + 1);
            return res;
        }
        // 在中间
        if(root.key >= root.left.key && root.key <= root.right.key){
            res = new Res(left.incLen+1, right.decLen+1);
            maxResLen = Math.max(maxResLen, left.incLen + right.decLen + 1);
        }else {
            res = new Res(left.decLen+1, right.incLen+1);
            maxResLen = Math.max(maxResLen, left.decLen + right.incLen + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Arrays.parallelSort(new int[]{});

    }

}
