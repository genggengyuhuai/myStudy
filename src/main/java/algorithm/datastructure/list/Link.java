package algorithm.datastructure.list;

/**
 * 链表倒数第k个节点    k 从 0 开始算 倒数第0个就是最后一个
 * @author lihaoyu
 * @date 2019/9/7 14:54
 */
public class Link {
    private static class Node{
        int key;
        Node next;
        public Node(int key, Node node) {
            this.key = key;
            this.next = node;
        }
    }

    private static int fun(Node firstNode, int k) throws Exception{
        if(firstNode == null) {
            throw new Exception();
        }
        Node temp = firstNode;
        while(k > 0){
            temp = temp.next;
            if(temp == null) {
                throw new Exception("good game");
            }
            k--;
        }
        Node resNode = firstNode;
        while(temp.next != null){
            temp = temp.next;
            resNode = resNode.next;
        }
        return resNode.key;
    }

    private static Node sort(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHead = slow.next;
        slow.next = null;
        Node temp1 = sort(head);
        Node temp2 = sort(secondHead);
        Node dummy = new Node(1,null), temp = dummy;
        while(temp1 != null && temp2 != null){
            if(temp1.key <= temp2.key){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null){
            temp.next = temp1;
        }else{
            temp.next = temp2;
        }
        return dummy.next;
    }

    //  k 个一组反转   K组
    private static Node groupReverse(Node node, int k){
        if(k <= 0) return node;
        Node tempNode = node;
        int tempK = 1;
        while(tempK != k && tempNode != null){
            tempNode = tempNode.next;
            tempK++;
        }
        if(tempK != k || tempNode == null) return node; // 不够一组
        Node nextGroupHead = tempNode.next;
        tempNode.next = null;
        Node newHead = reverse(node);
        node.next = groupReverse(nextGroupHead, k);
        return newHead;
    }

    private static Node reverse(Node node){
        if(node == null || node.next == null) return node;
        Node temp = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return temp;
    }

    public static void main(String[] args) throws Exception{
        Node eNode = new Node(5,null);
        Node dNode = new Node(4,eNode);
        Node cNode = new Node(3, dNode);
        Node bNode = new Node(2, cNode);
        Node aNode = new Node(1, bNode);
//      System.out.println(fun(aNode, 0));
//      System.out.println(sort(aNode));
        Node reverse = groupReverse(aNode,2);
        System.out.println();

    }
}
