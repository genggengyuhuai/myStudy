package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/12/28 14:52
 */
public class Main26 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 1;
        for (int i = 2; i <= n; i++) {
            int j = i;
            while(j!= 0 && j % 10 == 0){
                j %= 10;
            }
            if(j == 0) continue;
            if(res * j < 10){
                res *= j;
                continue;
            }
            if(res * j % 10 == 0){
                res = res * j / 10;
                continue;
            }
            res = res * j % 10;
        }
        System.out.println(res);

    }

}
