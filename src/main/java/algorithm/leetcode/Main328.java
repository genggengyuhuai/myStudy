package algorithm.leetcode;

import java.util.List;

/**
 * 奇偶链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * @author lihaoyu
 * @date 2019/12/9 19:55
 */
public class Main328 {
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


    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        int k = 0;
        ListNode cur = even.next;
        while(cur != null){
            if((k & 1) == 0){
                odd.next = cur;
                odd = cur;
            }else{
                even.next = cur;
                even = cur;
            }
            cur = cur.next;
            k++;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode reverse = oddEvenList(node1);
        ListNode temp = reverse;
        while(temp!= null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
