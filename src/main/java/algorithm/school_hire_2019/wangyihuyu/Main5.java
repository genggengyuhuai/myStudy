package algorithm.school_hire_2019.wangyihuyu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/5 16:41
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(nums);
        int count =  nums[0] + 1;
        int seed = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                seed = 0;
                continue;
            }
            count += (nums[i] - seed + 1);
            seed = nums[i];
        }
        System.out.println(count);


    }
}
