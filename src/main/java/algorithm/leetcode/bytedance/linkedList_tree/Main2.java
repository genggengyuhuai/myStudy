package algorithm.leetcode.bytedance.linkedList_tree;

/**
 * 反转链表
 * @author lihaoyu
 * @date 2020/7/28 12:17 AM
 */
public class Main2 {


    // 递归方法， 返回逆序后的头结点
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode newHead = reverseList(head.next);
        head.next =null;
        temp.next = head;
        return newHead;
    }

    // 朴素方法
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head.next, par = head, temp;
        par.next = null;
        while(cur != null){
            temp = cur.next;
            cur.next = par;
            par = cur;
            cur = temp;
        }
        return par;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);
        ListNode newHead = reverseList(l1);
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }
}
