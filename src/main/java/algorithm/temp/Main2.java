package algorithm.temp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/12/21 20:47
 */
public class Main2 {

    private static boolean fun(int[] a){
        Arrays.sort(a);
        for(int i = 1; i < a.length - 1; i++){
            if(a[i] * 2 != a[i-1]+a[i+1]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(fun(nums) ? "Possible" : "Impossible");
    }
}
