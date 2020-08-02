package algorithm.homework.secondtime;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/12 18:31
 */
public class Main4 {
    private static int fun(int n){
        if (n == 1){
            return 2;
        }
        else{
            return 2+3 * fun(n -1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = scanner.nextInt();
        for(int i = 0; i < caseNumber; i++){
            System.out.println(fun(scanner.nextInt()));
        }
    }
}
