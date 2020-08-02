package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 2N个数中有两个不同，用位运算求出来  93.33超时
 * @author lihaoyu
 * @date 2019/11/28 15:30
 */
public class Main14 {

    private static void fun(int[] nums,int size){
        int temp = nums[0];
        for(int i = 1; i < size; i++){
            temp = (temp ^ nums[i]);
        }
        int t = 1;
        while((temp & 1) != 1){
            temp = temp >> 1;
            t = t << 1;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < size; i++) {
            if((nums[i] & t) == 0){
                num1 = num1 ^ nums[i];
            }else{
                num2 = num2 ^ nums[i];
            }
        }
        if(num1 > num2){
            System.out.println(num2+" "+num1);
        }
        else{
            System.out.println(num1 + " "+num2);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int[] nums = new int[1000000];
         int size = 0;
         while(scanner.hasNext()){
             nums[size++] = scanner.nextInt();
         }
         fun(nums,size);
    }
}
