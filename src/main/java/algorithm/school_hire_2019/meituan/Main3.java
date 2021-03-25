package algorithm.school_hire_2019.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2021/3/21 3:41 下午
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            List<Integer> zeroList = new ArrayList<>();
            List<Integer> oneList = new ArrayList<>();
            List<Integer> twoList = new ArrayList<>();
            String temp = sc.next();
            for (int v = 1; v <= N; v++) {
                switch (temp.charAt(v-1)){
                    // v 是下标
                    case '0': zeroList.add(v); break;
                    case '1': oneList.add(v);break;
                    case '2': twoList.add(v);break;
                    default:break;
                }
            }
            PriorityQueue<Integer> zeroQueue = new PriorityQueue<>(zeroList);
            PriorityQueue<Integer> oneQueue = new PriorityQueue<>(oneList);
            PriorityQueue<Integer> twoQueue = new PriorityQueue<>(twoList);
            int M = sc.nextInt();
          String m = sc.next();
            for (int c = 0; c < m.length(); c++) {
                if(m.charAt(c)=='M'){
                    // 男 , 先看有没有一个的
                    if(oneQueue.size() != 0){
                        // 有，坐上
                        System.out.println(oneQueue.poll());
                        continue;
                    }
                    // 没有，找 0 个的 。  根据题目保证肯定能找到
                    int xx = zeroQueue.poll();
                    System.out.println(xx);
                    // 加到 1 个队列里面
                    oneQueue.add(xx);
                }else{
                    // 女，先看有没有两个的
                    if(zeroQueue.size() != 0){
                        // 有，坐上
                        int xx = zeroQueue.poll();
                        System.out.println(xx);
                        oneQueue.add(xx);
                        continue;
                    }
                    // 没有，找1个的
                    System.out.println(oneQueue.poll());
                }
            }
        }
    }
}
