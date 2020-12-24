package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @author lihaoyu
 * @date 2020/12/13 10:10 下午
 */
public class Main78 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> tempList = new ArrayList<>();

    private void fun(int[] nums, int i){
        res.add(new ArrayList<>(tempList));
        if(i == nums.length) return;
        for(int j = i; j < nums.length; j++){
            tempList.add(nums[j]);
            fun(nums,j+1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
fun(nums,0);
return res;
    }

    public static void main(String[] args) {
        Main78 main78 = new Main78();
        main78.fun(new int[]{1,2,3},0);
        System.out.println(main78.res);
    }
}
