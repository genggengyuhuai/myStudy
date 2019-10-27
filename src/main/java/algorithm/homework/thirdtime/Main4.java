package algorithm.homework.thirdtime;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/26 19:03
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0; t < T; t++){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            for(int i = 0; i < n; i++){
                if(i != n-1){
                    System.out.print(nums[i]+" ");
                }else{
                    System.out.print(nums[i]);
                }
            }
        }
    }
}
