package algorithm.jianzhi_offer;

/**
 * 旋转数组的最小数字
 * @author lihaoyu
 * @date 2/19/2020 7:09 PM
 */
public class Main3 {

    public static int minNumberInRotateArray2(int [] nums) {
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
        System.out.println(minNumberInRotateArray2(new int[]{10,10,10,1,10}));
    }

    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = (high + low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
}
