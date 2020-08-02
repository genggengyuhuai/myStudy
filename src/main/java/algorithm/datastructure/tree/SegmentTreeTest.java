package algorithm.datastructure.tree;

import java.util.Random;

/**
 * 线段树
 * 有一个一维数组，多次查询一个区间的最大值，或者和值，等等   但是元素可能会被修改
 *  意义在于 多次修改 log(n) 和 多次查询 log(n)
 * @author lihaoyu
 * @date 3/19/2020 7:43 PM
 */
public class SegmentTreeTest {

    private static class Node{
        int start, end, val;
        Node left, right;

        public Node(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    private static int[] a;

    // 建树
    private static Node createTree(int start, int end){
        if(start > end) return null;
        Node root = new Node(start, end, a[start]);
        if(start == end) return root;
        int mid = (start + end) >> 1;
        // 后序遍历时修改 Node 的 val
        root.left = createTree(start, mid);
        root.right = createTree(mid+1, end);
        if(root.left != null) root.val = Math.max(root.val, root.left.val);
        if(root.right != null) root.val = Math.max(root.val, root.right.val);
        return root;
    }

    // 查找某个区间的最大值  输入要合法
    private static int find(int start, int end, Node root){
        if(root == null) return 0;
        if(root.start == start && root.end == end) return root.val;
         int mid = (root.start + root.end) >> 1;
         if(end <= mid) return find(start,end, root.left);
         if(start >= mid + 1) return find(start, end, root.right);
        int left = find(start, mid, root.left);
        int right = find(mid+1, end, root.right);
        return Math.max(left, right);
    }

    // 修改了第 i 个元素后，保持树正确
    private static void updateNode(int index, Node root){
        if(root.start == index && root.end == index){
            root.val = Math.max(root.val, a[index]);
            return;
        }
        int mid = (root.start + root.end) >> 1;
        if(index <= mid)  updateNode(index, root.left);
        else  updateNode(index, root.right);
        root.val = Math.max(root.left.val, root.right.val);
    }


    public static void main(String[] args) {
        Random random = new Random(1);
        a = new int[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        Node root = createTree(0,a.length-1);
        System.out.println(find(0, 5, root));
        int index = 5;
        a[index] = 200;
        updateNode(index, root);
        System.out.println(find(0, a.length, root));
        System.out.println(root);

    }

}
