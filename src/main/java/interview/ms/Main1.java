package interview.ms;

/**
 * 2020.9.25 上午 11点 ms 苏州 STCA 面试
 * @author lihaoyu
 * @date 2020/9/24 11:06 下午
 */
public class Main1 {

    private static void quickSort(int[] nums, int left, int right){
        if(left >= right) return;
        int pivot = nums[left], start = left, end = right;
        while(start < end){
            while(start < end && nums[end] >= pivot) end--;
            nums[start] = nums[end];
            while(start < end && nums[start] <= pivot) start++;
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        quickSort(nums,left,start-1);
        quickSort(nums,start+1,end);
    }

    public static void main(String[] args) {

    }


}
