package algorithm.leetcode;

import algorithm.leetcode.bytedance.linkedList_tree.Main2;

/**
 * K 个一组反转链表
 *
 * @author lihaoyu
 * @date 2021/4/4 9:10 上午
 */
public class Main25 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
      // 先找到 k 个之后的那个头结点 的 父节点
        int t = k;
        ListNode nextHeadParent = head, nextHead, oldHead = head, newHead;
        while(k > 1 && nextHeadParent != null){
            nextHeadParent = nextHeadParent.next;
            k--;
        }
        if(nextHeadParent == null || nextHeadParent.next == null) return head; // 长度不够
        nextHead = nextHeadParent.next;  // 下一个头结点
        nextHeadParent.next = null; // 砍断
        // 反转本链表
        newHead = reverseList2(head);
        oldHead.next = reverseKGroup(nextHead,t);
        return newHead;
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
         ListNode node5 = new  ListNode(5, null);
         ListNode node4 = new  ListNode(4, node5);
         ListNode node3 = new  ListNode(3, node4);
         ListNode node2 = new  ListNode(2, node3);
         ListNode node1 = new  ListNode(1, node2);
         ListNode reverse = reverseKGroup(node1,2);
         ListNode temp = reverse;
        while(temp!= null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
