package algorithm.leetcode.listnode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * 环形链表 II   求交点
 *
 * @author lihaoyu
 * @date 2019/12/18 10:38
 */
public class Main142 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        // 不存在环
        if(slow == null || fast == null || fast.next == null) return null;
        ListNode cur = head;
        while(cur != slow){
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }


    public static void main(String[] args) {

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node5.next = node5;
        System.out.println(detectCycle(node1).val);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
        }
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("ggg");
        for (ListIterator<String> iterator = list.listIterator(list.size()); iterator.hasPrevious(); ) {
            String next = iterator.previous();
            System.out.println(next);
        }
    }
}
