package algorithm.school_hire_2019.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2/22/2020 9:35 PM
 */
public class Main31 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length-1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i+1]);
        }
        int[] res = new int[s.length-1];
        Arrays.fill(res,1);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) res[i] = res[i-1] + 1;
        }
        for (int i = nums.length-2; i >= 0; i--) {
            if(nums[i] > nums[i+1]) res[i] = Math.max(res[i], res[i+1] + 1);
        }
        int count = 0;
        for (int re : res) {
            count += re;
        }
        System.out.println(count);
    }
}
