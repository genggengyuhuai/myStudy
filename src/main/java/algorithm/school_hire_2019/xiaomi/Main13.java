package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/9 22:36
 */
public class Main13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] s = nextLine.split(" ");
        int[] nums = new int[s.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        int l = 0, r = nums.length - 1,temp;
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
        for (int i = 0; i < nums.length; i++) {
            if(i != nums.length -1){
                System.out.print(nums[i]+" ");
            }
            else {
                System.out.println(nums[i]);
            }
        }
    }

}
