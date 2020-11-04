package algorithm.contest.temp;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/12/4 20:02
 */
public class Main {

    private static class Node{
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }

        public Node() {
        }
    }

    private static Node fun(Node root1, Node root2){
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        Node head = new Node();
        Node cur = head;
        while(root1 != null && root2 != null){
            if(root1.key <= root2.key){
                cur.next = root1;
                root1 = root1.next;
            }else{
                cur.next = root2;
                root2 = root2.next;
            }
            cur = cur.next;
        }
        while(root1 != null){
            cur.next = root1;
            root1 = root1.next;
            cur = cur.next;
        }
        while(root2 != null){
            cur.next = root2;
            root2 = root2.next;
            cur = cur.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        String[] s2 = scanner.nextLine().split(" ");
        Node root1 = new Node();
        Node cur1 = root1;
        for (String s : s1) {
            cur1.next = new Node(Integer.parseInt(s));
            cur1 = cur1.next;
        }
        Node root2 = new Node();
        Node cur2 = root2;
        for (String s : s2) {
            cur2.next = new Node(Integer.parseInt(s));
            cur2 = cur2.next;
        }
        Node res = fun(root1.next,root2.next);
        while(res != null){
            System.out.print(res.key+" ");
            res = res.next;
        }
    }
}
