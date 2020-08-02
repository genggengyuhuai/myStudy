package algorithm.leetcode.tencent;

import java.util.Arrays;

/**
 * 搜索旋转排序数组
 * @author lihaoyu
 * @date 2019/11/28 20:30
 */
public class Main33 {

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1, mid;
        while(start < end){
            mid = (start + end) / 2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        // end 是最小值的位置
        if(target <= nums[nums.length - 1]){
            int i = Arrays.binarySearch(nums, end, nums.length, target);
            return i >= 0 ? i : -1;
        }
        int i = Arrays.binarySearch(nums, 0, end + 1, target);
        return i >= 0 ? i : -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
