package algorithm.school_hire_2019.pinduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 种树
 * 使用大顶堆失败，不满足输出最小字典序，例如 1 4 4
 * @author lihaoyu
 * @date 2019/11/9 20:02
 */
public class Main2 {

    private static class Tree implements Comparable<Tree> {
        int amount; //数量
        int index; // 字典序

        public Tree(int amount, int index) {
            this.amount = amount;
            this.index = index;
        }

        @Override
        public int compareTo(Tree o) {
            if (amount != o.amount) return amount - o.amount;
            return o.index - index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        List<Integer> res = new ArrayList<>();
        // 大顶堆
        PriorityQueue<Tree> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < M; i++) {
            queue.add(new Tree(scanner.nextInt(), i+1));
        }
        while (!queue.isEmpty()) {
            // 取出最大
            Tree max = queue.poll();
            // 最后了
            if(queue.size() == 0 && max.amount == 1){
                res.add(max.index);
                break;
            }
            // 最后一棵树的数量大于1,不存在
            if(queue.size() == 0 && max.amount > 1){
                System.out.println("-");
                return;
            }
            // 取出次大
            Tree secondMax = queue.poll();
            if(max.index < secondMax.index){
                res.add(max.index);
                res.add(secondMax.index);
            }
            else{
                res.add(secondMax.index);
                res.add(max.index);
            }
            if(max.amount-- != 1){
                queue.add(max);
            }
            if(secondMax.amount-- != 1){
                queue.add(secondMax);
            }
        }
        for (Integer re : res) {
            System.out.print(re+" ");
        }


    }
}
