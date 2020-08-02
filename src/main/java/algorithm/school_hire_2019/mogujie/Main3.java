package algorithm.school_hire_2019.mogujie;

import java.util.Scanner;

/**
 * 有N个孩子站成一排，每个孩子有一个分值。给这些孩子派发糖果，需要满足如下需求：
 * 1、每个孩子至少分到一个糖果
 * 2、分值更高的孩子比他相邻位的孩子获得更多的糖果
 * 求至少需要分发多少糖果？
 * @author lihaoyu
 * @date 2/2/2020 3:07 PM
 */
public class Main3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.next().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int[] res = new int[split.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) res[i] = res[i-1]+1;
            else res[i] = 1;
        }
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] > nums[i+1]) res[i] = Math.max(res[i],res[i+1]+1);
        }
        int sum = 0;
        for (int re : res) {
            sum += re;
        }
        System.out.println(sum);
    }
}
