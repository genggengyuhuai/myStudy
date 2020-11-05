package algorithm.school_hire_2019.bytedance;

import java.util.Collections;
import java.util.SortedSet;

/**
 * 加面
 * @author lihaoyu
 * @date 2020/11/5 11:18 上午
 */
public class Temp {

   // 快排 不稳定 n * log(n)
   private static void quickSort(int[] nums, int start, int end){
       if(nums == null || start >= end) return;
       int pivot = nums[start],left = start, right = end;
       while(left < end){
           while(left < right && nums[right] >= pivot) right--;
           nums[left] = nums[right];
           while(left < right && nums[left] <= pivot) left++;
           nums[right] = nums[left];
       }
       nums[left] = pivot;
       quickSort(nums,start,left-1);
       quickSort(nums,left+1,end);
   }


   // 二分 返回 Index  -1
    private static int binarySearch(int[] nums, int target){
       if(nums == null) return -1;
       int left = 0, right = nums.length-1;
       while(left <= right){
           int mid = (left + right) / 2;
            if(nums[target] == target) return mid;
            if(nums[mid] > nums[target]) right = mid -1;
            else left = mid + 1;
       }
       return -1;
    }

    // 二分，返回第一个大于 target 的 index
    private static int binarySearch2(int[] nums, int target){
        if(nums == null) return -1;
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] <= target) left = mid+1;
            else right = mid;
        }
       return -1;
    }

    // 冒泡排序
   private static void bubbleSort(int[] nums){
       if (nums == null || nums.length <= 1) return;
       for (int i = 0; i < nums.length; i++) {
           for (int j = 0; j < nums.length-1-i; j++) {
                if(nums[j+1] < nums[j]) swap(nums,j,j+1);
           }
       }
   }

   private static void swap(int[] nums, int i, int j){
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
   }

    public static void main(String[] args) {

    }

}
