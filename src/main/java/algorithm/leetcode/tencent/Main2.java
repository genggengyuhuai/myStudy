package algorithm.leetcode.tencent;

/**
 * 链表形式的两数相加
 * @author lihaoyu
 * @date 2019/11/28 20:13
 */
public class Main2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位
        boolean C = false;
        ListNode tail = null;
        ListNode head = null;
        ListNode node;
        int temp = 0;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                temp = l1.val + l2.val + (C ? 1 : 0);
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l2 != null){
                temp = l2.val + (C ? 1 : 0);
                l2 = l2.next;

            }else{
                temp = l1.val + (C ? 1 : 0);
                l1 = l1.next;
            }
            node = new ListNode(temp % 10);
            C = temp >= 10;
            if(head == null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail = tail.next;
            }
        }
        if(C){
            tail.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
