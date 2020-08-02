package algorithm.leetcode.tencent;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lihaoyu
 * @date 2019/11/4 10:42
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
public class Main23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));
        for (ListNode list : lists) {
            if(list != null){
                queue.add(list);
            }
        }
        root = queue.poll();
        if(root == null) return null;
        if(root.next!=null){
            queue.add(root.next);
        }
        ListNode temp = root;
        while(!queue.isEmpty()){
            temp.next = queue.poll();
            if(temp.next.next != null){
                queue.add(temp.next.next);
            }
            temp = temp.next;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(4);
        root.next.next = new ListNode(5);

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);

        ListNode root3 = new ListNode(2);
        root3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = root;
        lists[1] = root2;
        lists[2] = root3;

        Main23 main4 = new Main23();
        ListNode node = main4.mergeKLists(lists);
        while(node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}
