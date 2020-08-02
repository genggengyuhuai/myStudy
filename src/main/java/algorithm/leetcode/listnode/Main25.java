package algorithm.leetcode.listnode;

/**
 * K 个一组翻转链表  逆序
 *
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * @author lihaoyu
 * @date 2019/12/9 19:19
 */
public class Main25 {
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

    private static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode par = head;
        ListNode cur = head.next;
        ListNode post;
        head.next = null;
        while(cur != null){
            post = cur.next;
            cur.next = head;
            head = cur;
            cur = post;
        }
        return head;
    }

    private static ListNode reverseRecursive(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode reverse = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for(int i = 1; i < k && temp != null; i++){
            temp = temp.next;
        }
        if(temp == null) return head;
        ListNode newHead = temp.next;
        temp.next = null;
        ListNode res = reverseRecursive(head);
        head.next = reverseKGroup(newHead,k);
        return res;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode reverse = reverseKGroup(node1,3);
        ListNode temp = reverse;
        while(temp!= null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
