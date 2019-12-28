package algorithm.school_hire_2019.kuaishou;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 给定两个-100到100的整数x和y,对x只能进行加1，减1，乘2操作，问最少对x进行几次操作能得到y？
 * 例如：
 * a=3,b=11: 可以通过3*2*2-1，3次操作得到11；
 * a=5,b=8：可以通过(5-1)*2，2次操作得到8；
 * @author lihaoyu
 * @date 2019/12/28 14:21
 */
public class Main25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int x = Integer.parseInt(next.split(",")[0]);
        int y = Integer.parseInt(next.split(",")[1]);
        if(y <= x){
            System.out.println( x - y);
            return;
        }
        if(y <= 0){
            System.out.println(Math.abs(x - y));
            return;
        }
        int count = 0;
        if( x <= 1){
            count += 1 - x;
            x = 1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(x);
        // 用来记录有没有出现过
        boolean[] flags = new boolean[101];
        while(true){
            // 先查一下有没有
            if(list.contains(y)){
                System.out.println(count);
                return;
            }
            int len = list.size();
            count++;
            for(int i = 0; i < len; i++){
                Integer temp = list.pollFirst();
                if(temp - 1 > 0 && temp - 1 <= 100 && !flags[temp-1]) {
                    list.addLast(temp-1);
                    flags[temp-1] = true;
                }
                if(temp + 1 > 0 && temp + 1 <= 100 && !flags[temp+1]) {
                    list.addLast(temp+1);
                    flags[temp+1] = true;
                }
                if(temp * 2 > 0 && temp * 2 <= 100 && !flags[temp*2]) {
                    list.addLast(temp*2);
                    flags[temp*2] = true;
                }
            }
        }

    }
}
