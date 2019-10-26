package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 * 给满出二叉树，编写算法将其转化为求和树
 *
 * 什么是求和树：二叉树的求和树， 是一颗同样结构的二叉树，其树中的每个节点将包含原始树中的左子树和右子树的和。
 *
 * 二叉树：
 *                   10
 *                /      \
 *              -2        6
 *            /   \      /  \
 *           8    -4    7    5
 *
 * 求和树：
 *                  20(4-2+12+6)
 *                /      \
 *            4(8-4)      12(7+5)
 *             /   \      /  \
 *           0      0    0    0
 *
 * 二叉树给出前序和中序输入，求和树要求中序输出；
 * 所有处理数据不会大于int；
 *
 * @author lihaoyu
 * @date 2019/10/15 11:03
 */

class Node {
    int key;
    Node left;
    Node right;
    int sum;

    public Node(int key) {
        this.key = key;
    }
}

public class Main2 {


    private static Node fun2(int []pre, int[] in, int pre_start, int pre_end, int in_start, int in_end){
        if(pre_start > pre_end || in_start > in_end) return null;
        Node root = new Node(pre[pre_start]);
        int key = pre[pre_start];
        int index = in_start;
        for(int i=in_start;i<=in_end;i++){
            if(in[i] == key) {index = i;break;}
        }
        root.left = fun2(pre,in,pre_start+1,index-in_start+pre_start,in_start,index-1);
        root.right = fun2(pre,in,index-in_start+pre_start+1,pre_end,index+1,in_end);

        return root;
    }
    

    private static void print(Node root) {
        if (root == null)
            return;
        print(root.left);
        System.out.print(root.key + " ");
        print(root.right);
    }

    private static void sum(Node root) {
//        if (root.left.left == null && root.left.right == null && root.right.left == null && root.right.right == null) {
//            return root.key + root.left.key + root.right.key;
//        }
        if(root == null) return;
        if(root.left == null && root.right == null){
            root.sum = root.key;
            root.key = 0;
            return;
        }
         sum(root.left);
         sum(root.right);
        root.sum = root.key;
        int tempL = root.left != null ? (root.left.sum + root.left.key) : 0;
        int tempR = root.right != null ? (root.right.sum + root.right.key):0;
        root.key = tempL + tempR;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String aString = scanner.nextLine();
            String bString = scanner.nextLine();
            String[] aSplit = aString.split("( )+");
            String[] bSplit = bString.split("( )+");
            int[] a = new int[aSplit.length];
            int[] b = new int[aSplit.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(aSplit[i]);
                b[i] = Integer.parseInt(bSplit[i]);
            }
            Node root = fun2(a,b,0,a.length-1,0,b.length-1);
           sum(root);
             print(root);

        }
    }
}
