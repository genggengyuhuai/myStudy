package algorithm.homework.firsttime;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/13 22:19
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n == 0){
                break;
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                count += scanner.nextInt();
            }
            System.out.println(count);
        }
    }
}
