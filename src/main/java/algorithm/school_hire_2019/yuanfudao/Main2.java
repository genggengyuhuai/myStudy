package algorithm.school_hire_2019.yuanfudao;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/4 17:21
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String next = scanner.nextLine();
        int index = 0;
        int k = (N - 1) / 3;
        for(int row = 0; row < k; row++){
            for(int temp = 0; temp < row; temp++){
                System.out.print(" ");
            }
            System.out.print(next.charAt(index++));
            for(int temp = 0; temp < 2*k-1-row*2; temp++){
                System.out.print(" ");
            }
            System.out.println(next.charAt(index++));
        }
        for(int i = 0; i <= k; i++){
            for(int temp = 0; temp < k; temp++){
                System.out.print(" ");
            }
            System.out.println(next.charAt(index++));
        }
    }

}
