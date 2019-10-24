package algorithm.jiu_shi_gan.kuaishou;

import java.util.Scanner;

/**
 * 快手	字符串包含	1067	25.22%
 *
 * 我们定义字符串包含关系：字符串A=abc，
 * 字符串B=ab，字符串C=ac，则说A包含B，A和C没有包含关系。
 *
 * @author lihaoyu
 * @date 2019/10/22 16:58
 */
public class Main12 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
        String s1 = scanner.next();
        String s2 = scanner.next();
            int res1 = s1.indexOf(s2);
            int res2 = s2.indexOf(s1);
            if(res1 != -1 || res2 != -1){
                System.out.println(1);
            }else System.out.println(0);


        }

    }
}
