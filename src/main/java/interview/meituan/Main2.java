package interview.meituan;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 3/12/2020 7:18 PM
 */
public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] nums = new int[2048];
        for (int i = 0; i < n; i++) {
            nums[scanner.nextInt()] += 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            if((i|x) == i) continue;
            nums[i|x] += nums[i];
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        System.out.println(max);
    }


}
