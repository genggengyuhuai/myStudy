package algorithm.homework.thirdtime;

import java.util.Scanner;

/**
 * 计数排序  时间复杂度 O(n+k)  空间也是
 * 开了一个 max - min + 1 大小的数组记录count
 *
 * @author lihaoyu
 * @date 2019/10/27 9:53
 */
public class Main6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0 ; i < n; i++){
                nums[i] = scanner.nextInt();
            }
            fun(nums);
            for(int i = 0; i < n; i++){
                if(i == n - 1){
                    System.out.println(nums[i]);
                }else{
                    System.out.print(nums[i]+" ");
                }
            }
        }
    }

    private static void fun(int[] nums) {
        int max = nums[0], min = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min,nums[i]);
        }
        int[] temp = new int[max-min+1];
        for(int i = 0; i < nums.length; i++){
            temp[nums[i] - min]++;
        }
        int j = 0;
        for(int i = 0; i < temp.length; i++){
            while(temp[i] != 0){
                nums[j++] = min + i;
                temp[i]--;
            }
        }
    }
}
