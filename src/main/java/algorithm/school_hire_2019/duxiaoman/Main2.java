package algorithm.school_hire_2019.duxiaoman;

import java.util.Scanner;

/**
 * 股票交易，可以买卖多次，但手中最多一个股票
 * @author lihaoyu
 * @date 2/5/2020 7:50 PM
 */
public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        int index = 0;
        long peek = nums[0], valley = nums[0], res = 0, count = 0;
        while(index < N - 1){
            while(index < N - 1 && nums[index] >= nums[index+1]){
                index++;
            }
            valley = nums[index];
            while(index < N - 1 && nums[index] <= nums[index+1]){
                index++;
            }
            peek = nums[index];
            res += (peek - valley);
            if(peek > valley){
                count += 2;
            }
        }
        System.out.println(res+" "+count);
    }
}
