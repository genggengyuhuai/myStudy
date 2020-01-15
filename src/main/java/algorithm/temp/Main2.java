package algorithm.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    private static void select(int i){
        if(temp.size() == selectNum){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i; j < nums.length; j++){
            temp.add(nums[j]);
            select(j+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void fun(int[] a, int start, int end){
        if(start >= end) return;
        int mid = (start + end) / 2, left = start, right = mid+1, index = 0;
        fun(a,start,mid);
        fun(a,mid+1,end);
        // 开一个数组
        int[] temp = new int[end-start+1];
        while(left <= mid && right <= end){
            if(a[left] <= a[right]) temp[index++] = a[left++];
            else temp[index++] = a[right++];
        }
        while(left <= mid) temp[index++] = a[left++];
        while(right <= end) temp[index++] = a[right++];
        System.arraycopy(temp,0,a,start,end-start+1);
    }



    public static void main(String[] args) {
        int[] arr = new int[]{5,1,8,2,-3,9,4};
        fun(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }


//        fun2();
            select(0);
        for (List<Integer> re : res) {
//            System.out.println(re);
        }
    }
}
