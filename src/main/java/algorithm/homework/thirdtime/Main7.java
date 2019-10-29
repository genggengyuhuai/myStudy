package algorithm.homework.thirdtime;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/28 19:18
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] s = scanner.nextLine().split(" ");
            int[] nums = new int[s.length];
            int n = nums.length;
            for(int i = 0 ; i < n; i++){
                nums[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(nums);
            for(int i = 0; i < n; i++){
                if(i == n - 1){
                    System.out.println(nums[i]);
                }else{
                    System.out.print(nums[i]+" ");
                }
            }
        }
    }
}
