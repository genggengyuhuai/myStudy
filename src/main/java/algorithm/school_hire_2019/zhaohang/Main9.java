package algorithm.school_hire_2019.zhaohang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 飘流船问题
 * @author lihaoyu
 * @date 2020/2/12 20:44
 */
public class Main9 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int limit = scanner.nextInt();
        Arrays.sort(nums);
        int left = 0, right = nums.length-1, count = 0;
        while(left <= right){
            if(nums[left] + nums[right] <= limit){
                left++;right--;
            }else{
                right--;
            }
            count++;
        }
        System.out.println(count);
    }
}
