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
    
    private static void noRecursivePostOrderVisit(Node root){
        if(root == null) return;
        LinkedList<Node> list = new LinkedList<>();
        LinkedList<Node> res = new LinkedList<>();
        list.addLast(root);
        while(!list.isEmpty()){
            Node temp = list.pollLast();
            res.addLast(temp);
            if(temp.left != null) list.addLast(temp.left);
            if(temp.right != null) list.addLast(temp.right);
        }
        res.forEach(s-> System.out.println(s.key+" "));
    }

    public static void main(String[] args) {

    }
}
