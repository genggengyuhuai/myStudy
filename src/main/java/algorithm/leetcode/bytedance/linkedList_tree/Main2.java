package algorithm.leetcode.bytedance.linkedList_tree;

/**
 * 反转链表
 * @author lihaoyu
 * @date 2020/7/28 12:17 AM
 */
public class Main2 {


    // 递归方法， 返回逆序后的头结点
    public ListNode reverseList(ListNode head) {
        ListNode newHead = reverseList(head.next);
        head.next =

        return null;
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

    }
}
