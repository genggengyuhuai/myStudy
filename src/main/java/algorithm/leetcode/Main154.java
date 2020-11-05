package algorithm.leetcode;

/**
 * 寻找旋转排序数组中的最小值 II
 * 数组里有重复值
 * @author lihaoyu
 * @date 2020/11/5 2:09 下午
 */
public class Main154 {

    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int low = 0 , mid, high = nums.length - 1;
        while(low < high){
            if(nums[low] < nums[high]) return nums[low];
            mid = (high + low) / 2;
            if(nums[low] < nums[mid]){
                low = mid + 1;
            }
            else if(nums[low] == nums[mid]){
                low++;
            }
            else{
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {

    }
}
