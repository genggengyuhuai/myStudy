package algorithm.leetcode.bytedance.linkedList_tree;

/**
 * 环形链表
 * @author lihaoyu
 * @date 2020/7/28 12:17 AM
 */
public class Main5 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head, slow = head, temp = head;
        boolean flag = true;
        while(slow != fast || flag){
            flag = false;
            slow = slow.next;
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
        }
        while(temp != slow){
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println(detectCycle(l1).val);
    }
}
