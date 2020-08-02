package algorithm.school_hire_2019.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/9 20:48
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int[] res = new int[n/2];
        for(int i = 0; i < n/2; i++){
            res[i] = nums[i] + nums[n-i-1];
        }
        Arrays.sort(res);
        System.out.println(res[n/2-1] - res[0]);
    }
}
