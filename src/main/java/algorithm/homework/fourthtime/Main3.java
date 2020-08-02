package algorithm.homework.fourthtime;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/19 10:48
 */
public class Main3 {

    private static void fun(int[] a, int gap){
        int i, j, temp;
        for(i = gap; i < a.length; i++){
            for(j = i; j >= gap && a[j] < a[j - gap]; j -= gap){
                temp = a[j];
                a[j] = a[j - gap];
                a[j - gap] = temp;
            }
        }
    }

    private static int[] transfer(String[] s){
        int[] a = new int[s.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < T; t++) {
            String[] a = scanner.nextLine().split(" ");
            String[] b = scanner.nextLine().split(" ");
            int[] nums = transfer(a);
            int[] gaps = transfer(b);
            for (int gap : gaps) {
                fun(nums,gap);
            }
            for (int i = 0; i < nums.length; i++) {
                if(i!= nums.length -1){
                    System.out.print(nums[i]+" ");
                }else{
                    System.out.println(nums[i]);
                }
            }
        }

    }
}
