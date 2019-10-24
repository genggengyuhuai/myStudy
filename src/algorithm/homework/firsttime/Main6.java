package algorithm.homework.firsttime;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/13 22:36
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int count = 0;
            for(int i = 0; i < n; i++){
                count += scanner.nextInt();
            }
            System.out.println(count);
        }
    }
}
