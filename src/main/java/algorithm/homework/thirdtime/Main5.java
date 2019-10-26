package algorithm.homework.thirdtime;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/26 8:54
 */
public class Main5 {

    public static void fun(int[] nums){
        int len = nums.length;
        int temp;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

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
                    System.out.print(nums[i]);
                }else{
                    System.out.print(nums[i]+" ");
                }
            }
        }
    }
}
