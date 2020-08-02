package algorithm.leetcode.bytedance.linkedList_tree;

import algorithm.jianzhi_offer.Main2.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 *
 * @author lihaoyu
 * @date 2020/8/1 2:25 下午
 */
public class Main9 {

    private List<List<TreeNode>> res = new ArrayList<>();

    private void fun(TreeNode root, int level) {
        if (root == null) return;
        if (res.size() <= level) res.add(new ArrayList<>());
        res.get(level).add(root);
        fun(root.left, level + 1);
        fun(root.right, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        fun(root,0);
        for (int i = 0; i < res.size(); i++) {
            list.add(new ArrayList<>());
            if ((i & 1) == 0)
                for (TreeNode tempNode : res.get(i))
                    list.get(i).add(tempNode.val);
            else
                for (int j = res.get(i).size() - 1; j >= 0; j--)
                    list.get(i).add(res.get(i).get(j).val);
        }
        return list;
    }


    public static void main(String[] args) {

    }
}
