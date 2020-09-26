package interview.ms;

/**
 * 2020.9.25 上午 11点 ms 苏州 STCA 面试
 *
 * @author lihaoyu
 * @date 2020/9/24 11:06 下午
 */
public class Main1 {

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = nums[left], start = left, end = right;
        while (start < end) {
            while (start < end && nums[end] >= pivot) end--;
            nums[start] = nums[end];
            while (start < end && nums[start] <= pivot) start++;
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        quickSort(nums, left, start - 1);
        quickSort(nums, start + 1, end);
    }

    private static class Node {
        int key;
        Node next;
    }

    private Node NodeMergeSort(Node root) {
        if (root == null || root.next == null) return root;
        // root 不会为空
        Node midNode = getMiddleNode(root), SecondHead = midNode.next;
        midNode.next = null;
        Node newHead1 = NodeMergeSort(root);
        Node newHead2 = NodeMergeSort(SecondHead);
        return mergePartition(newHead1,newHead2);
    }

    private Node getMiddleNode(Node root) {
        // 不可有环
        if (root == null || root.next == null) return root;
        Node fast = root;
        while (fast != null && fast.next != null) {
            root = root.next;
            fast = fast.next.next;
        }
        return root;
    }

    private Node mergePartition(Node root1, Node root2) {
        Node dummy = new Node(), root = dummy;
        while (root1 != null && root2 != null) {
            if (root1.key <= root2.key) {
                dummy.next = root1;
                root1 = root1.next;
            } else {
                dummy.next = root2;
                root2 = root2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = root1 == null ? root2 : root1;
        return root.next;
    }

    public static void main(String[] args) {

    }


}
