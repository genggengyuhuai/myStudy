package algorithm.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2019/12/21 20:47
 */
public class Main2 {

    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> temp = new ArrayList<>();
    private static int[] nums = new int[]{1, 2, 3, 4};
    private static boolean[] flags = new boolean[nums.length];
    private static int selectNum = 2;

    // 全排列, 基于交换
    private static void fun(int i) {
        if (i == nums.length) {
            temp = new ArrayList<>();
            for (int k = 0; k < nums.length; k++) {
                temp.add(nums[k]);
            }
            res.add(temp);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(i, j);
            fun(i + 1);
            swap(i, j);
        }
    }

    private static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 全排列， 基于 flag
    private static void fun2() {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                temp.add(i + 1);
                flags[i] = true;
                fun2();
                flags[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    // 选择数


    public static void main(String[] args) {
        fun2();
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
