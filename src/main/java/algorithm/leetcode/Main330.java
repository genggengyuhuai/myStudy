package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * hard 的贪心，2019年3月份腾讯机试第三题
 * 问要覆盖 1-n 的金额至少要多少张钱
 * @author lihaoyu
 * @date 2/7/2020 9:15 PM
 */
public class Main330 {

    // 注意 nums 已经有序
    public static int minPatches(int[] nums, int n) {
        // miss 是当前未覆盖的最小值 ，index 是 nums 的下标
        int miss = 1, index = 0;
        Set<Integer> needAdd = new HashSet<>();
        while(miss <= n){
            if(index < nums.length && nums[index] <= miss){
                miss += nums[index++];
            }else{
                needAdd.add(miss);
                miss += miss;
            }
        }
        return needAdd.size();
    }

    public static void main(String[] args) {

    }
}
