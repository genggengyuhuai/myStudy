package algorithm.leetcode;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。
 * @author lihaoyu
 * @date 2/22/2020 6:20 PM
 */
public class Main138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    static void insertNodes(Node head){


    }

    public static Node copyRandomList(Node head) {
        if(head == null) return null;
        Node head2 = head, head3 = head;
        // 每个节点后面插入一个
        while(head != null){
            Node newNode = new Node(head.val);
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
        // 复制随机节点
        while(head2 != null){
            head2.next.random = head2.random == null ? null : head2.random.next;
            head2 = head2.next.next;
        }

        // 拆开节点
        Node tempHead;
        Node res = head3.next;
        while(head3 != null){
            tempHead = head3.next;
            head3.next = head3.next.next;
            tempHead.next = tempHead.next == null ? null : tempHead.next.next;
            head3 = head3.next;
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
