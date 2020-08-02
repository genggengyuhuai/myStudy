package algorithm.leetcode;

/**
 * 旋转排序数组
 * @author lihaoyu
 * @date 2/29/2020 1:27 PM
 */
public class Main143 {

    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        int mid;
        while(left < right){
            mid = (left + right) >> 1;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                right = right - 1;
            }
        }
        return nums[left];
    }

}
