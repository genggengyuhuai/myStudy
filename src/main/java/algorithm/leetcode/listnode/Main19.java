package algorithm.leetcode.listnode;


/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author lihaoyu
 * @date 2019/12/5 22:55
 */
public class Main19 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // n 保证是有效的
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode temp = head;
        while(n-- != 0){
            temp = temp.next;
        }
        if(temp == null){
            // 删除头结点
            return head.next;
        }
        ListNode par = head;
        ListNode delete = head;
        while(temp != null){
            par = delete;
            delete = delete.next;
            temp = temp.next;
        }
        par.next = delete.next;
        return head;
    }

    public static void main(String[] args) {
        int i = 1;
    }
}
