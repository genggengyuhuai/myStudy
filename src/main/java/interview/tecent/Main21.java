package interview.tecent;

import java.util.LinkedList;

/**
 * @author lihaoyu
 * @date 2020/9/26 10:23 上午
 */
public class Main21 {

    private static class Node{
        int key;
        Node right;
        Node left;
    }

    private static void recursiveInOrderVisit(Node root){
        if(root == null) return;
        recursiveInOrderVisit(root.left);
        System.out.println(root.key+" ");
        recursiveInOrderVisit(root.right);
    }

    private static void noRecursiveInOrderVisit(Node root){
        if(root == null) return;
        LinkedList<Node> list = new LinkedList<>();
        while(root != null || !list.isEmpty()){
            while(root != null){
                list.addLast(root);
                root = root.left;
            }
            if(!list.isEmpty()){
                root = list.pollLast();
                System.out.println(root.key);
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {

    }
}
