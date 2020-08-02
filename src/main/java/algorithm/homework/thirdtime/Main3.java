package algorithm.homework.thirdtime;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/26 18:42
 */
public class Main3 {

    public static void fun(String[] c,int k){
        int len = c.length;
        String temp;
        for(int i = 0; i + k <= len; i += k){
            for(int j = 0; j < k/2;j++){
                temp = c[i+j];
                c[i+j] = c[i+k-1-j];
                c[i+k-1-j] = temp;
            }
        }
        for(int i = 0; i < len; i++){
            if(i != len - 1){
                System.out.print(c[i]+" ");
            }else{
                System.out.print(c[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for(int t = 0; t < T; t++){
            String next = scanner.nextLine();
            String[] split = next.split(" ");
            String[] strings = new String[split.length-2];
            for(int i = 0; i <strings.length; i++){
                strings[i] = split[i+1];
            }
            int k = Integer.parseInt(split[split.length - 1]);
            fun(strings, k);
        }

    }

}
