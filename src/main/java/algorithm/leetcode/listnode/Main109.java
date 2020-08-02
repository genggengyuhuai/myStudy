package algorithm.leetcode.listnode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @author lihaoyu
 * @date 2019/12/5 21:27
 */
public class Main109 {

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

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    // 找一个链表的中间节点
    private static ListNode findMiddleNode(ListNode head, ListNode end) {
        if (head == null) return null;
        if(head == end) return null;
        ListNode slow = head;
        ListNode fast = head;
        while ( fast.next != end && fast.next.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static TreeNode buildTree(ListNode start, ListNode end) {
        ListNode middleNode = findMiddleNode(start, end);
        if (middleNode == null) return null;
        TreeNode root = new TreeNode(middleNode.val);
        root.left = buildTree(start, middleNode);
        root.right = buildTree(middleNode.next, end);
        return root;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        TreeNode treeNode = buildTree(node1, null);

    }
}
