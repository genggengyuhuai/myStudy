package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 米兔从兔米那里了解到有一个无限长的数字序列 1,  2，3，3，4，4，4,  5，5，5，5，5 ...,(已知此数列有一定规律，现将这些数字按不同数值堆叠，相同值的数字在同一层)。
 * 米兔想知道这个数字序列的第n个数所在的那一层之前的所有层里共有多少个数。
 * @author lihaoyu
 * @date 2019/11/12 13:44
 */
public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        if(num == 1 || num == 2){
            System.out.println(num-1);
            return;
        }
        long a = 1, b = 1,temp,count=2;
        while(true){
            temp = b;
            b = a + b;
            a = temp;
            if(count + b >= num){
                break;
            }
            count += b;
        }
        System.out.println(count);
    }
}
