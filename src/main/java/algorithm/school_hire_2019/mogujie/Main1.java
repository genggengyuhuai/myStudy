package algorithm.school_hire_2019.mogujie;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/4 9:37
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        long up = 1, down = 1,i = 0;
        while(i < x){
        up *= (x+y-i);
        down *= 1+i;
        i++;
        }
        System.out.println(up/down);
    }
}
