package algorithm.leetcode;

import java.util.LinkedList;

/**
 * @author lihaoyu
 * @date 2019/12/5 16:00
 */
public class Main116 {


private static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

    public Node connect(Node root) {
    if(root == null) return null;
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        int curDepth = 0, curLevelNode = 1, nextLevelNode = 0;
        Node right = null;
        while(!list.isEmpty()){
            Node node = list.pollFirst();
            node.next = right;
            right = node;
            if(node.right != null){
                list.addLast(node.right);
                nextLevelNode++;
            }
            if(node.left != null){
                list.addLast(node.left);
                nextLevelNode++;
            }
            curLevelNode--;
            if(curLevelNode == 0){
                curDepth++;
                curLevelNode = nextLevelNode;
                nextLevelNode = 0;
                right = null;
            }
        }

    return root;
    }


    public static void main(String[] args) {

    }

}
