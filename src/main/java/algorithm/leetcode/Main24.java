package algorithm.leetcode;

import algorithm.leetcode.bytedance.linkedList_tree.Main2;

import java.util.List;

/**
 * 两两交换链表中的节点
 * @author lihaoyu
 * @date 2020/11/14 23:57
 */
public class Main24 {
  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode swapPairs(ListNode head) {
    // 递归
        if(head == null|| head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        ListNode nextHead = head.next.next;
        newHead.next = head;
        head.next = swapPairs(nextHead);
       return newHead;
    }

    public static ListNode swapPairs2(ListNode head) {
        // 非递归
        if(head == null || head.next == null){
            return head;
        }
       ListNode dummy = new ListNode(1), parent = dummy;
        while(head != null && head.next != null){
            ListNode curHead = head.next;
            head.next = curHead.next;
            curHead.next = head;
            head = head.next;
            parent.next = curHead;
            parent = curHead.next;

        }
        return dummy.next;
    }

    // 朴素方法
    public static ListNode reverseList2(ListNode head) {
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


    public static void main(String[] args) {
        ListNode node4 = new ListNode(4,null);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
       ListNode res =  reverseList2(node1);
       while(res != null){
           System.out.print(res.val+" ");
           res = res.next;
       }
    }

}
