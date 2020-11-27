package algorithm.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2020/11/18 9:48 上午
 */
public class Temp4 {

    private static List<Integer> temp = new ArrayList<>();
    private static List<List<Integer>> res = new ArrayList<>();

    private static void swap(int[] nums, int i, int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private static void fun(int[] nums, int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        for (int j = i; j < nums.length; j++) {
            swap(nums,i,j);
            fun(nums,i+1);
            swap(nums,i,j);
        }
        temp.remove(temp.size()-1);
    }


    public static void main(String[] args) {
        fun(new int[]{1,2,3},0);
        System.out.println(res);
    }
}
