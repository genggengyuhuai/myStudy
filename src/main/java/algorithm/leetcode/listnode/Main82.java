package algorithm.leetcode.listnode;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * @author lihaoyu
 * @date 2019/12/5 23:08
 */
public class Main82 {
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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(2);
        dummy.next = head;
        ListNode cur = head;
        ListNode par = dummy;
        while(cur != null){
            if(cur.next == null){
                break;
            }
            if(cur.next.val != cur.val){
                par = cur;
                cur = cur.next;
                continue;
            }
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            par.next = cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode res = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode temp = node1;
        while(temp!= null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
        ListNode reverse = reverse(node1);
        temp = reverse;
        while(temp!= null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

    }
}
