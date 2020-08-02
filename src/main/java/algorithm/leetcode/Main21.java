package algorithm.leetcode;


/**
 * @author lihaoyu
 * @date 2020/5/19 9:43 上午
 */
public class Main21 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) cur.next = l1;
        else cur.next = l2;
        return dummy.next;
    }
}
