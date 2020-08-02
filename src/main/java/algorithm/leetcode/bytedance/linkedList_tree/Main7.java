package algorithm.leetcode.bytedance.linkedList_tree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个有序链表
 *
 * @author lihaoyu
 * @date 2020/7/28 12:17 AM
 */
public class Main7 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(1), head = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if(node == null) continue;
            queue.add(node);
        }
        while(!queue.isEmpty()){
            ListNode next = queue.poll();
            if(next.next != null) queue.add(next.next);
            dummy.next = next;
            dummy = dummy.next;
        }
        return head.next;
    }


    public static void main(String[] args) {

    }


}
