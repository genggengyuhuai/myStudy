package algorithm.leetcode.tencent;

/**
 * 旋转链表
 * @author lihaoyu
 * @date 2019/11/28 21:00
 */
public class Main61 {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int len = 0;
        ListNode temp = head;
        ListNode readHead = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        k = k % len;
        if(k == 0) return head;
        temp = head;
        int tempK = k;

        while(tempK-- != 0){
            temp = temp.next;
        }
        ListNode pre = null;
        while(temp != null){
            pre = head;
            head = head.next;
            temp = temp.next;
        }
        ListNode newNode = pre.next;
        pre.next = null;
        while(head.next != null){
            head = head.next;
        }
        head.next = readHead;
        return newNode;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(rotateRight(node1,2).val);
    }
}
