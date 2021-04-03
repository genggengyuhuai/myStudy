package algorithm.leetcode;

/**
 * 反转链表
 * @author lihaoyu
 * @date 2021/4/3 2:18 下午
 */
public class Main206 {
    static class ListNode {
        int val;
      ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 递归
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode newHead = reverseList(head.next);
        head.next = null;
        temp.next = head;
        return newHead;
    }

    // 非递归
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode par = head, cur = head.next,temp;
        head.next = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = par;
            par = cur;
            cur = temp;
        }
        return par;
    }

}
