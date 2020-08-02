package algorithm.datastructure.list;

/**
 * @author lihaoyu
 * @date 2019/11/21 15:44
 */
public class DoubleLink<E> {

    Node<E> head;
    Node<E> tail;

    private void add(E add){
        Node<E> node = new Node<>(add);
        if (node == null) {
            throw new NullPointerException("node 为 空");
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while(cur != null){
            sb.append(cur.key).append(" ");
            cur = cur.next;
        }
        sb.append("\n头是 ").append(head.key).append(" 尾是 ").append(tail.key);
        return sb.toString();
    }

    private static class Node<T>{
        T key;
        Node<T> next;
        Node<T> prev;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }

        public Node(T key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        DoubleLink<String> link = new DoubleLink<>();
        link.add("1");
        link.add("2");
        link.add("3");
        link.add("4");
        System.out.println(link);
    }


}
