package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 求倒数第k个节点
 * @author lihaoyu
 * @date 2019/11/9 21:47
 */


public class Main12 {

    private static class Node{
        private int key;
        private Node next;

        public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }

        @Override
        public String toString() {
            return key+"";
        }
    }

    /***
     * 倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    static int count = 0;
    private static Node fun(Node head, int k){
        if(head == null){
            return null;
        }
        Node res = fun(head.next, k);
        count++;
        if(count == k){
            return head;
        };
        return res;
    }

    public static void main(String[] args) {
        Node node7 = new Node(7,null);
        Node node6 = new Node(6,node7);
        Node node5 = new Node(5,node6);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);

        Scanner scanner = new Scanner(System.in);
        System.out.println(fun(node1, scanner.nextInt()));
    }
}
