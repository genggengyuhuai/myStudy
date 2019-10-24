package algorithm.main.netesay;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lihaoyu
 * @date 2019/10/9 9:12
 */
public class MyQueue {
    public static void main(String[] args) {
        PriorityQueue<MyNode> queue = new PriorityQueue((Comparator<MyNode>) (o1, o2) -> o2.key - o1.key);
        queue.add(new MyNode(3,"gg"));
        queue.add(new MyNode(1,"gg"));
        queue.add(new MyNode(2,"gg"));

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}


class MyNode implements Comparable<MyNode>{
    public int key;
    public String name;

    @Override
    public String toString() {
        return "MyNode{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }

    public MyNode(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int compareTo(MyNode o) {
        return key - o.key;
    }
}