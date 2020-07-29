package algorithm.leetcode.bytedance.linkedList_tree;

/**
 * 两数相加
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author lihaoyu
 * @date 2020/7/28 12:17 AM
 */
public class Main3 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode dummy = new ListNode(0), cur = dummy;
        int C = 0;
        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val + C) % 10);
            C = (l1.val + l2.val + C) >= 10 ? 1 : 0;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = new ListNode((l1.val + C) % 10);
            C = (l1.val + C) >= 10 ? 1 : 0;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode((l2.val + C) % 10);
            C = (l2.val + C) >= 10 ? 1 : 0;
            cur = cur.next;
            l2 = l2.next;
        }
        // 最后一位
        if (C != 0) cur.next = new ListNode(1);
        return dummy.next;
    }

    public static void main(String[] args) {
        // 第一个是 7 -> 8   即 87
        ListNode l1_1 = new ListNode(7);
        ListNode l1_2 = new ListNode(8);
        l1_1.next = l1_2;
        // 第二个是 6 -> 4 -> 9   即 946
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);
        ListNode l2_3 = new ListNode(9);
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        ListNode listNode = addTwoNumbers(l1_1, l2_1);
        while(listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
