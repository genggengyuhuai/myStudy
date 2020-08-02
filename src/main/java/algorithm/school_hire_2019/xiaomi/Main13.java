package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 小米	数组操作	1200	19.89%  超时
 * @author lihaoyu
 * @date 2019/11/9 22:36
 */
public class Main13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[1000000];
        int size = 0;
        while(scanner.hasNext()){
            nums[size++] = scanner.nextInt();
        }
        int l = 0, r = size - 1,temp;
        while(l < r){
            while((nums[l] & 1) == 0 && l < r){
                l++;
            }
            while((nums[r] & 1) != 0 && l < r){
                r--;
            }
            if(l < r){
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        for (int i = 0; i < size; i++) {
            if(i != size -1){
                System.out.print(nums[i]+" ");
            }
            else {
                System.out.println(nums[i]);
            }
        }
    }

}
