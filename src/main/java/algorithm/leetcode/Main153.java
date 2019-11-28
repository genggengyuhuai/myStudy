package algorithm.leetcode;

/**
 * 寻找旋转排序数组中的最小值
 * @author lihaoyu
 * @date 2019/11/28 16:57
 */
public class Main153 {

    private static int fun(int[] nums){
        int start = 0, end = nums.length - 1, mid;
        while(start < end){
            mid = (start + end) / 2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(fun(nums));
    }
}
