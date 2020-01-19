package algorithm.leetcode.listnode;

/**
 * @author lihaoyu
 * @date 2020/1/19 19:40
 */
public class LinkNodeSortTest {

    private static class Node{
        Node next;
        int key;

        public Node(int key, Node next) {
            this.next = next;
            this.key = key;
        }
    }

    private static Node sortList(Node first){
        if(first == null || first.next ==  null) return first;
        Node fast = first, slow = first;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 断开
        Node secondFirst = slow.next;
        slow.next = null;
        // 注意返回值的使用
        Node node = sortList(first);
        Node node1 = sortList(secondFirst);
        return merge(node, node1);
    }

    private static Node merge(Node node1, Node node2){
        Node dummy = new Node(1,null), tail = dummy;
        while(node1 != null && node2 != null){
            if(node1.key <= node2.key){
                tail.next = node1;
                node1 = node1.next;
            }else{
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        tail.next = (node1 == null ? node2 : node1);
        return dummy.next;
    }

    public static void main(String[] args) {
        Node dNode = new Node(1,null);
        Node cNode = new Node(2, dNode);
        Node bNode = new Node(3, cNode);
        Node aNode = new Node(4, bNode);
        Node node = sortList(aNode);
        while(node != null){
            System.out.print(node.key+" ");
            node = node.next;
        }
    }
}
