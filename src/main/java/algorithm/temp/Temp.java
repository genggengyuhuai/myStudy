package algorithm.temp;

/*
排序数组  -3, -2,-2,1,1,2,2,3,4 输出每个
元素平方后有多少个不同的元素  空间O(1)
 */
public class Temp {

    private static int fun(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1, res = 0;
        while (left <= right) {

            if (Math.abs(nums[left]) == Math.abs(nums[right])) {
                // 边界
                if (left == 0 || right == nums.length - 1 ||
                        (nums[left - 1] != nums[left] && nums[right] != nums[right + 1])) {
                    res++;
                }
                left++;
                right--;
            } else if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                // 相异才计数
                if (left == 0 || nums[left - 1] != nums[left]) {
                    res++;
                }
                left++;
            } else {
                if (right == nums.length - 1 || nums[right + 1] != nums[right]) {
                    res++;
                }
                right--;
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{-5, -4, -3, -1, 1, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(fun(nums));
    }
}