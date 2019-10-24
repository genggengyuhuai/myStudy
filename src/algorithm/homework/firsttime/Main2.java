package algorithm.homework.firsttime;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/13 22:15
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int a, b;
            for(int i = 0; i < n; i++){
                a = scanner.nextInt();
                b = scanner.nextInt();
                System.out.println(a + b);
            }
        }
    }
}
