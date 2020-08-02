package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 *
 * 输入年、月、日，计算该天是本年的第几天。
 * @author lihaoyu
 * @date 2019/10/26 19:26
 */
public class Main20 {

    private static final int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

    private static boolean isRun(int year){
        if(year % 4 != 0) return false;
        if(year % 100 == 0 && year % 400 != 0) return false;
        return true;
    }

    private static int fun(int year, int month, int day){
        int count = 0;
        for(int i = 0; i < month - 1; i++){
            if(i==1 && isRun(year)){
                count += 29;
                continue;
            }
            count += days[i];
        }
        count += day;
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            System.out.println(fun(year,month,day));
        }
    }
}
