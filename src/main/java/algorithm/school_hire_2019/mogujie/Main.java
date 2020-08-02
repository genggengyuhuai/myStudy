package algorithm.school_hire_2019.mogujie;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/4 10:18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s1.length + s.length];
        int i ;
        for(i = 0; i < s.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        for(i = 0; i < s1.length; i++){
            nums[i + s.length] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(nums);
        for(i = 0; i < nums.length; i++){
            if( i != nums.length - 1){
                System.out.print(nums[i]+" ");
            }else{
                System.out.println(nums[i]);
            }
        }

    }
}
