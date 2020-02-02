package algorithm.school_hire_2019.shopee;

import java.util.Scanner;

/**
 * 走方格的方法数
 * @author lihaoyu
 * @date 2/2/2020 12:43 PM
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        long[][] a = new long[x+1][y+1];
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            a[x - scanner.nextInt()][y - scanner.nextInt()] = -1;
        }
        int temp;
        for (temp = 0; temp <= x && a[temp][0] != -1; temp++)   a[temp][0] = 1;
        for (; temp <= x; temp++) a[temp][0] = 0;
        for (temp = 0; temp <= y && a[0][temp] != -1; temp++)   a[0][temp] = 1;
        for (; temp <= y; temp++) a[0][temp] = 0;

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if(a[i][j] == -1){
                    a[i][j] = 0;
                    continue;
                }
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }

        System.out.println(a[x][y]);
    }


}
