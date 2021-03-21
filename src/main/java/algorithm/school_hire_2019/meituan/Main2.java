package algorithm.school_hire_2019.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2021/3/17 1:36 下午
 */
public class Main2 {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                int n = sc.nextInt();
                int[] array = new int[n];
                for (int i = 0; i < n; i++) {
                    array[i] = sc.nextInt();
                }
                Arrays.sort(array);
                int res = 0;
                for (int i = 0; i < n; i++) {
                    res += Math.abs(array[i] - i - 1);
                }
                System.out.println(res);
            }
    }
}
