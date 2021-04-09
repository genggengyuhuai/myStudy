package algorithm.leetcode.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * @author lihaoyu
 * @date 2019/11/28 19:26
 */
public class Main15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int start, end, count ;
        for(int i = 0; i < len && nums[i] <= 0; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            // 双指针
            for(start = i + 1, end = len - 1; start < end;){
                if(start != i+1 && end != len-1 && nums[start] == nums[start-1]
                && nums[end] == nums[end+1])
                {
                    start++;end--;continue;
                }
                count = nums[i] + nums[start] + nums[end];
                if(count == 0){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[start]);
                    tempList.add(nums[end]);
                    resList.add(tempList);
                    start++;end--;
                }else if(count < 0){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
