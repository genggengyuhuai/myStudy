package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * @author lihaoyu
 * @date 2019/12/6 18:29
 */
public class Main15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        // a + b = -c   循环 c，从 小于0的到0
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i]; // 目标数，然后用双指针去找
            int left = 0, right = nums.length - 1;
            while(left < right){
                // 相同的情况
                if(left != 0 && nums[left] == nums[left-1]){
                    left++;
                    continue;
                }
                if(right != nums.length-1 && nums[right] == nums[right+1]){
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if(sum == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(target);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                }else if (sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
