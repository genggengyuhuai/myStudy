package algorithm.jiu_shi_gan.kuaishou;

import java.util.Scanner;

/**
 *  快手	合并数组	1116	16.53%
 *
 * 请实现一个函数，功能为合并两个升序数组为一个升序数组
 *
 * @author lihaoyu
 * @date 2019/10/22 16:23
 */
public class Main11 {


    public static String fun(int[] a1,int[] a2){
        int[] res = new int[a1.length + a2.length];
        int i=0,j=0,index=0;
        while(i < a1.length && j < a2.length) {
            if (a1[i] <= a2[j]) {
                res[index++] = a1[i++];
            } else {
                res[index++] = a2[j++];
            }
        }
            while(i < a1.length){
                res[index++] = a1[i++];
            }
            while(j < a2.length){
                res[index++] = a2[j++];
            }

        for(int k = 0; k < res.length; k++){
            if(k != res.length-1){
                System.out.print(res[k]+",");
            }
            else{
                System.out.println(res[k]);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.next();
            if(!scanner.hasNext()){
                System.out.println(s1);
                return;
            }
            String s2 = scanner.next();
            int[] a1 = fun(s1);
            int[] a2 = fun(s2);
            String fun = fun(a1, a2);


        }
    }

    public static int[] fun(String string){
        String[] split = string.split(",");
        int[] res = new int[split.length];
        for(int i = 0; i < split.length; i++){
            res[i] = Integer.parseInt(split[i]);
        }
        return res;
    }
}
