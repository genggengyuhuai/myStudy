package algorithm.contest.fourth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 订单问题
 * Rahul and Ankit are the only two waiters in Royal Restaurant.
 * Today, the restaurant received N orders. The amount of tips may differ when handled by
 * different waiters, if Rahul takes the ith order, he would be tipped Ai rupees and if Ankit
 * takes this order, the tip would be Bi rupees.In order to maximize the total tip value they decided to distribute the order among themselves.
 * One order will be handled by one person only. Also, due to time constraints Rahul cannot take more than X orders and Ankit cannot take more than Y orders.
 * It is guaranteed that X + Y is greater than or equal to N, which means that all the orders can be handled by either Rahul or Ankit.
 * Find out the maximum possible amount of total tip money after processing all the orders
 * @author lihaoyu
 * @date 2019/11/21 9:08
 */
public class Main2 {

    private static class Node implements Comparable<Node>{
        int value;
        boolean aBoolean;
        int index;

        public Node(int value, boolean aBoolean, int index) {
            this.value = value;
            this.aBoolean = aBoolean;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return value - o.value;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Node(scanner.nextInt(),true,i));
            }
            for (int i = 0; i < N; i++) {
                list.add(new Node(scanner.nextInt(),false,i));
            }
            list.sort(Comparator.reverseOrder());
            Set<Integer> indexSet = new HashSet<>();
            int sum = 0;
            for (int i = 0; i < list.size() && N != 0; i++) {
                Node node = list.get(i);
                if(indexSet.contains(node.index)){
                    continue;
                }
                if(node.aBoolean && X != 0){
                    sum += node.value;
                    indexSet.add(node.index);
                    X--;
                    N--;
                }
                else if(!node.aBoolean && Y != 0){
                    sum += node.value;
                    indexSet.add(node.index);
                    Y--;
                    N--;
                }
            }
            System.out.println(sum);
        }
    }
}
