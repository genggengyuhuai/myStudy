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

    public static void main(String[] args) throws Exception{
        Node dNode = new Node(4,null);
        Node cNode = new Node(3, dNode);
        Node bNode = new Node(2, cNode);
        Node aNode = new Node(1, bNode);
        System.out.println(fun(aNode, 0));
    }
}
