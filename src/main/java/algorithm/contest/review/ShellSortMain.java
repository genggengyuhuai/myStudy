package algorithm.contest.review;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/12/1 21:35
 */
public class ShellSortMain {

    private static void fun(int[] a, int gap){
        int i, j, temp, len = a.length;
        for(i = gap; i < len; i++){
            for(j = i; j >= gap && a[j] < a[j - gap]; j--){
                temp = a[j];
                a[j] = a[j - gap];
                a[j - gap] = temp;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < T; t++) {
            String[] s = scanner.nextLine().split(" ");
            int[] numbers = new int[s.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(s[i]);
            }
            String[] s2 = scanner.nextLine().split(" ");
            int[] gaps = new int[s2.length];
            for (int i = 0; i < gaps.length; i++) {
                gaps[i] = Integer.parseInt(s2[i]);
                fun(numbers,gaps[i]);
            }
            for (int i1 = 0; i1 < numbers.length; i1++) {
                if(i1 != numbers.length - 1){
                    System.out.print(numbers[i1] +" ");
                }else{
                    System.out.println(numbers[i1]);
                }
            }


        }

    }
}
