package algorithm.contest.fifth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/28 10:00
 */
public class Main3 {

    private static class Job implements Comparable<Job>{
        int id;
        int ddl;
        int profit;

        public Job(int id, int ddl, int profit) {
            this.id = id;
            this.ddl = ddl;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            return profit - o.profit;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            List<Job> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Job(scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
            }
            list.sort(Comparator.reverseOrder());
            boolean[] time = new boolean[101];
            int sumProfit = 0, count = 0;
            int ddl, i;

            for (Job job : list) {
                 ddl = job.ddl;
                boolean done = false;
                for(i = ddl - 1; i >= 0; i--){
                    if(!time[i]){
                        done = true;
                        time[i] = true;
                        break;
                    }
                }
                if(done){
                    count++;
                    sumProfit += job.profit;
                }

            }
            System.out.println(count+" "+sumProfit);
        }
    }
}
