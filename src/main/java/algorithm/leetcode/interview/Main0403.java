package algorithm.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2020/5/5 8:42 下午
 */


public class Main0403 {

    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return new ListNode[0];
        LinkedList<TreeNode> list = new LinkedList<>();
        List<ListNode> res = new ArrayList<>();
        list.add(tree);
        while(!list.isEmpty()){
            int len = list.size();
            ListNode node = null;
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = list.pollFirst();
                if(treeNode.left != null) list.addLast(treeNode.left);
                if(treeNode.right != null) list.addLast(treeNode.right);
                if(i == 0){
                    node = new ListNode(treeNode.val);
                    res.add(node);
                    continue;
                }
                node.next = new ListNode(treeNode.val);
                node = node.next;
            }
        }
        ListNode[] array = new ListNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }
}
