package algorithm.datastructure.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 牛客
 *
 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 set(key, value)：将记录(key, value)插入该结构
 get(key)：返回key对应的value值
 [要求]
 set和get方法的时间复杂度为O(1)
 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 若opt=1，接下来两个整数x, y，表示set(x, y)
 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 对于每个操作2，输出一个答案
 * @author lihaoyu
 * @date 2020/9/9 8:53 上午
 */
public class MyLRU2 {

     Map<Integer, Node> map = new HashMap<>();
     Node head = new Node(-1), tail = new Node(-1);
     int K = 0;

     class Node{
        int value;
        Node prev, next;
        Node(int value){
            this.value = value;
        }
    }

    // 添加一个元素时。 1. 在里面    把其移动到首部     2. 不在里面    加到首部   并判断容量，移除尾部


    void moveNode2Head(Node node){
        node.next = head;
        head = node;
    }



    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.K = k;


        return null;
    }


    public static void main(String[] args) {

    }
}
