package algorithm.leetcode.bytedance.linkedList_tree;

/**
 * 链表排序 归排
 * @author lihaoyu
 * @date 2020/7/28 12:17 AM
 */
public class Main4 {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = fun(head), secondHead = mid.next;
        mid.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(secondHead);
        return fun2(first, second);
    }

   private static ListNode fun(ListNode head){
        // head 不能为 null
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
   }

   private static ListNode fun2(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0), head = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                dummy.next = head1;
                head1 = head1.next;
            }else{
               dummy.next = head2;
               head2 = head2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = head1 == null ? head2 : head1;
        return head.next;
   }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l1 = sortList(l1);
        while(l1 != null){
            System.out.println(l1.val+" ");
            l1 = l1.next;
        }
    }
}
