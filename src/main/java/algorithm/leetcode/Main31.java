package algorithm.leetcode;

import java.util.Arrays;

/**
 *  31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * @author lihaoyu
 * @date 2019/12/24 20:01
 */
public class Main31 {

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i,j;
        for(i= nums.length - 1; i >= 1; i--){
          if(nums[i] > nums[i-1]){
              break;
          }
        }
         if(i == 0){
             Arrays.sort(nums);
             return;
         }
        // 找第一个大于 nums[i-1]的
        for(j = nums.length-1; j >= i; j--){
            if(nums[j] > nums[i-1]){
                break;
            }
        }
        swap(nums,i-1,j);
        Arrays.sort(nums,i,nums.length);
    }


    public static void main(String[] args) {
    int[] nums = new int[]{4,2,0,2,3,2,0};
    nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
