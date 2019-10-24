package algorithm.main.netesay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 19 网易校招  25通过率  	牛牛的闹钟
 * 牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 * 输出描述:
 * 输出两个整数表示牛牛最晚起床时间。
 * @author lihaoyu
 * @date 2019/9/7 15:53
 */
public class Main7 {

    private static class Time implements Comparable<Time>{
        private int hour;

        private int min;

        private int total;

        private Time(int hour, int min, int total) {
            this.hour = hour;
            this.min = min;
            this.total = total;
        }

        @Override
        public int compareTo(Time o) {
            return total - o.total;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Time> list = new ArrayList<>();
        while(scanner.hasNext()){
            int N = scanner.nextInt();
            for(int i = 0; i < N; i++){
                int hour = scanner.nextInt();
                int min = scanner.nextInt();
                list.add(new Time(hour, min, hour * 60 + min));
            }
            Collections.sort(list);
            int X = scanner.nextInt();
            int hour = scanner.nextInt();
            int min = scanner.nextInt();
            Time classBegin = new Time(hour, min, hour * 60 + min);
            int lastTime = classBegin.total >= X ?  classBegin.total - X : 24*60 + (classBegin.total - X);
            for(int i = list.size() - 1; i >= 0; i--){
                if(list.get(i).total <= lastTime){
                    System.out.println(list.get(i).hour+" "+list.get(i).min);
                    break;
                }
            }
        }
    }
}
