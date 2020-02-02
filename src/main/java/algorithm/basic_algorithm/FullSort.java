package algorithm.basic_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 求 全排列  两种方法
 *
 * @author lihaoyu
 * @date 2019/12/12 14:41
 */
public class FullSort {

    private static List<String> res = new ArrayList<>();

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void fun(char[] arr, int i) {
        if (i == arr.length) {
            res.add(new String(arr));
            return;
        }
        // 注意是从 i 开始， 否则 3 * 2 * 1 * 0 最后是0了
        for (int j = i; j < arr.length; j++) {
            swap(arr,i,j);
            fun(arr,i+1);
            swap(arr, i,j);
        }
    }

    // 用 flags 标记来求全排列   注意：这种方法符合字典序
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
        fun(new char[]{'1','2','3'},0);
        System.out.println(res);

        res.clear();
        fun(new int[]{1,2,3,4},0,new boolean[4],"",res);
        System.out.println(res);
    }

}
