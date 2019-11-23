package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 小米	最优分割	326	23.73%
 * 依次给出n个正整数A1，A2，… ，An，将这n个数分割成m段，每一段内的所有数的和记为这一段的权重，
 * m段权重的最大值记为本次分割的权重。问所有分割方案中分割权重的最小值是多少？
 * @author lihaoyu
 * @date 2019/11/22 12:30
 */
public class Main25 {

    private static int fun(int[] a, int k){
        int sum = 0, max = a[0], mid = 0, len = a.length;
        for (int i : a) {
            sum += i;
            max = Math.max(max,i);
        }
        // 答案在 max 和 sum 之间，用二分
        while(max < sum){
            mid = (max + sum) / 2;
            int tempSum = 0, tempK = 0;
            for(int i = 0; i < len; i++){
                // 需要分割一次
                if(tempSum + a[i] > mid){
                    tempSum = a[i];
                    tempK++;
                }else{
                    tempSum += a[i];
                }
            }
            // 说明分割次数太多，mid需要变大
            if(tempK > k - 1){
                max = mid + 1;
            }else{
                sum = mid;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println(fun(nums,k));
    }
}
