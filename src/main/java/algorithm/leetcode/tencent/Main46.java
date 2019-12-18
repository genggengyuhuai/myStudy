package algorithm.leetcode.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列   经典 swap 交换 + 回溯
 * @author lihaoyu
 * @date 2019/12/18 15:22
 */
public class Main46 {

    private static void fun(List<List<Integer>> res, int[] nums, int i){
        if(i == nums.length){
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
            return;
        }

        for(int j = i; j < nums.length; j++){
            swap(nums,i,j);
            fun(res,nums,i+1);
            swap(nums,i,j);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        fun(res,nums,0);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
