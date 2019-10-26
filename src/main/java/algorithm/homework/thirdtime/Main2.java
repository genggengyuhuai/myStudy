package algorithm.homework.thirdtime;

import java.util.Scanner;

/**
 * 判断链表回文
 *
 * @author lihaoyu
 * @date 2019/10/26 8:41
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.next();
        for(int t = 0; t < T; t++){
            String[] split = scanner.nextLine().split(" ");
            boolean flag = true;
            int len = split.length;
            for(int i = 1; i <= len / 2; i++){
                if(!split[i].equals(split[len - i])){
                    flag = false;
                    break;
                }
            }
            System.out.println(flag);
        }
    }
}
