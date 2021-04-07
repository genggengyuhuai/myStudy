package algorithm.leetcode;

/**
 * 第 K 大,   直接分治
 *
 * @author lihaoyu
 * @date 2021/4/3 2:28 下午
 */
public class Main215 {

    // k 总是 有效的
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return partition(nums, k, 0, nums.length - 1);
    }

    public static int partition(int[] nums, int k, int start, int end) {
        if (start >= end) return nums[start];
        int pivot = nums[start], left = start, right = end;
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        if (end - right == k - 1) return nums[right];
        if (end - right > k - 1) return partition(nums, k, right + 1, end);
        return partition(nums, k - 1 - end + right, start,left - 1);
    }


}
