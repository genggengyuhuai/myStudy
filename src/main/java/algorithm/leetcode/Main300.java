package algorithm.leetcode;

/**
 * 最长上升子序列的长度
 * @author lihaoyu
 * @date 2019/11/28 16:03
 */
public class Main300 {

    // 二分法找到第一个大于key的index
    private static int findIndex(int[] nums, int size, int key){
        int start = 0, end = size - 1, mid;
        while(start < end){
            mid = ( start + end ) / 2;
            if(nums[mid] >= key){
                if(mid == 0 || nums[mid-1] < key){
                    return mid;
                }
                end = mid - 1;
            }
            start = mid + 1;
        }
        return end;
    }


    public static int fun(int[] nums){
        if(nums == null) return 0;
        int[] stack = new int[nums.length];
        int size = 0,  res = 0;
        for (int num : nums) {
            if(size == 0 || num > stack[size - 1]){
                stack[size++] = num;
            }else{
                int index = findIndex(stack, size, num);
                stack[index] = num;
            }
            res = Math.max(size, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,10,4,3,8,9};
        System.out.println(fun(nums));
    }

}
