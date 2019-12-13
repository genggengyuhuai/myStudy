package algorithm.basic_algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 求 全排列
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

    public static void main(String[] args) {
        fun(new char[]{'1','2','3'},0);
        System.out.println(res);
    }

}
