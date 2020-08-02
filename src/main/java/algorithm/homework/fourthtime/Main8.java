package algorithm.homework.fourthtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/19 12:10
 */
public class Main8 {

    static class Node implements Comparable<Node>{
        private int value;
        private int times;

        public Node(int value, int times) {
            this.value = value;
            this.times = times;
        }

        @Override
        public int compareTo(Node o) {
            if(times != o.times){
                return -this.times + o.times;
            }
           return this.value - o.value;
        }
    }

    private static void fun(int[] nums){
        Map<Integer, Integer> map = new HashMap<>(256);
        for (int num : nums) {
            Integer integer = map.getOrDefault(num, 0);
            map.put(num,integer+1);
        }
        List<Node> list = new ArrayList<>();
        map.forEach((k,v) -> list.add(new Node(k,v)));
        Collections.sort(list);
        List<Integer> res = new ArrayList<>();
        for (Node node : list) {
            while(node.times != 0){
                res.add(node.value);
                node.times--;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if(i != res.size() - 1){
                System.out.print(res.get(i)+" ");
            }else{
                System.out.println(res.get(i));
            }
        }

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            fun(nums);



        }
    }
}
