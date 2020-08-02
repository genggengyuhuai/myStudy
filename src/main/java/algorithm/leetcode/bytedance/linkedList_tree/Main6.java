package algorithm.leetcode.bytedance.linkedList_tree;

/**
 * 找链表交点 可能无
 * @author lihaoyu
 * @date 2020/7/28 12:17 AM
 */
public class Main6 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode lastA = headA, lastB = headB;
        int lenA = 1, lenB = 1;
        while(lastA.next != null){
            lenA++;
            lastA = lastA.next;
        }
        while(lastB.next != null){
            lenB++;
            lastB = lastB.next;
        }
        if(lastA != lastB) return null;
        ListNode fast = lenA >= lenB ? headA : headB, low = lenA >= lenB ? headB : headA;
        // fast 先走
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            fast = fast.next;
        }
        while(fast != low){
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }

    public static void main(String[] args) {

    }
}
