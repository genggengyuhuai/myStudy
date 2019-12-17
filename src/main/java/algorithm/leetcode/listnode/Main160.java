package algorithm.leetcode.listnode;

/**
 * @author lihaoyu
 * @date 2019/12/17 14:48
 */
public class Main160 {
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int len1 = 1;
        int len2 = 1;
        ListNode temp1 = headA;
        while(temp1.next != null){
            len1++;
            temp1 = temp1.next;
        }
        ListNode temp2 = headB;
        while(temp2.next != null){
            len2++;
            temp2 = temp2.next;
        }
        // 没有交点
        if(temp2 != temp1) return null;
        int gap = Math.abs(len1-len2);
        ListNode temp;
        // 1 号 为长的
        if(len1 < len2){
            temp = headA;
            headA = headB;
            headB = temp;
        }
        while(gap != 0){
            headA = headA.next;
            gap--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }


}
