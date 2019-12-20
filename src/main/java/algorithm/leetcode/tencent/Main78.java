package algorithm.leetcode.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author lihaoyu
 * @date 2019/12/18 16:26
 */
public class Main78 {


    private static void fun(int[] nums, int j, boolean[] flags, String sb, List<String> res) {
        if (j >= nums.length) {
            res.add(sb);
            return;
        }
            for (int i = 0; i < nums.length; i++) {
                if (!flags[i]) {
                flags[i] = true;
                fun(nums, j + 1, flags, sb+nums[i], res);
                flags[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        fun(new int[]{1,2,3},0,new boolean[3],"",res);
        System.out.println(res);
    }
}
