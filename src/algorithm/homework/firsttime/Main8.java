package algorithm.homework.firsttime;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/13 22:34
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            for(int i = 0; i < n; i++){
                int m = scanner.nextInt();
                int count = 0;
                for(int j = 0; j < m; j++){
                    count += scanner.nextInt();
                }
                System.out.println(count);
                System.out.println();
            }
        }
    }
}
