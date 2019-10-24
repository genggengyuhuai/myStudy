package algorithm.main.kuaishou;

import java.util.Scanner;

/**
 * 快手	最少数量货物装箱问题	941	30.05%
 * 有重量分别为3，5，7公斤的三种货物，和一个载重量为X公斤的箱子（不考虑体积等其它因素，只计算重量）
 * 需要向箱子内装满X公斤的货物，要求使用的货物个数尽可能少（三种货物数量无限）
 * @author lihaoyu
 * @date 2019/10/23 14:59
 */
public class Main14 {

    public static boolean flag = true;
    public static int count = 0;
    public static void fun(int X, int[] key,int j){

        if(!flag) {
            return;
        }
        count++;
        if(X-key[j] == 0){
            flag = false;
            return;
        }
        if(X-key[j]<0) {

            return;
        }

        for(int i = 0; i < 3; i++) {
            fun(X-key[j],key,i);
            if(flag){
                count--;
            }

        }
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        for(int i = 0; i < 3; i++) {
            fun(X,new int[]{7,5,3},i);
            if(flag){
                count--;
            }
        }
        if(!flag) {
            System.out.println(count);
        }else System.out.println(-1);
    }


}
