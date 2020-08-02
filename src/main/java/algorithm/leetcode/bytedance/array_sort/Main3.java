package algorithm.leetcode.bytedance.array_sort;

import java.util.Arrays;

/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * @author lihaoyu
 * @date 2020/7/4 10:30 上午
 */
public class Main3 {

    // 先找分界点
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int temp1 = Arrays.binarySearch(nums, 0, left, target);
        int temp2 = Arrays.binarySearch(nums, left, nums.length, target);
        if (temp1 >= 0) return temp1;
        else return temp2 >= 0 ? temp2 : -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
