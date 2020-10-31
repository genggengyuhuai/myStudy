package algorithm.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * @author lihaoyu
 * @date 2/22/2020 7:24 PM
 */
public class Main347 {

    static class Node implements Comparable<Node>{
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", count=" + count +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return count - o.count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Node> nodeList = new ArrayList<>();
        map.forEach((a,b)-> nodeList.add(new Node(a,b)));
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Node node : nodeList) {
            if(queue.size() < k){
                queue.add(node);
                continue;
            }
            if(queue.peek().compareTo(node) <= 0){
                queue.poll();
                queue.add(node);
            }
        }
        List<Integer> res = new ArrayList<>();
        queue.forEach(s -> res.add(s.index));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Main347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
