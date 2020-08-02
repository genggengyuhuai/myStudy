package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/12 14:03
 */
public class Main17 {

    private static int tempFun(int[] nums, int l, int r){
        int res = 0;
        int height = Math.min(nums[l], nums[r]);
        res += height * (r - l - 1);
        for(int i = l + 1; i < r; i++){
            res -= nums[i];
        }
        return res;
    }


    private static int fun(int[] nums){
        int len = nums.length, i = 0,res = 0;
        while(i < len - 1){
            int peek, low,start = i;
            while(i < len - 1 && nums[i] >= nums[i+1]){
                i++;
            }
            low = i;
            while(i < len - 1 && nums[i] <= nums[i+1]){
                i++;
            }
            peek = i;
            res += tempFun(nums,start,peek);
        }
         return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] s = nextLine.split(",");
        int[] nums = new int[s.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(fun(nums));
    }
}
