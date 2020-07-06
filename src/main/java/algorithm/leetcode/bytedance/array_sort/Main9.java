package algorithm.leetcode.bytedance.array_sort;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *   合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * @author lihaoyu
 * @date 2020/7/5 10:43 上午
 */
public class Main9 {

    private static class Node implements Comparable<Node>{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if(start != o.start)
            return start - o.start;
            return end - o.end;
        }
    }


    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0][0];
        List<Node> list = new ArrayList<>(intervals.length);
        List<Node> resList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Node(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(list);
        int tempStart = Integer.MIN_VALUE;
        int tempEnd = tempStart;
        // 要特殊处理一下第一个 res 元素
        for (Node node : list) {
            if(node.start > tempEnd){
                // 直接结束
                resList.add(new Node(tempStart, tempEnd));
                tempStart = node.start;
                tempEnd = node.end;
                continue;
            }
            if(node.end > tempEnd){
                tempEnd = node.end;
            }
        }
        // 最后一个也要处理一下
        Node last = resList.get(resList.size()-1);
        if(last.end < tempStart) resList.add(new Node(tempStart,tempEnd));
        else if(last.end < tempEnd) last.end = tempEnd;

        int [][] res = new int[resList.size()-1][2];
        for (int i = 1; i < resList.size(); i++) {
            res[i-1][0] = resList.get(i).start;
            res[i-1][1] = resList.get(i).end;
        }
        return res;
    }


    public static void main(String[] args) {
        Main9 main9 = new Main9();
        int[][] merge = main9.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            System.out.println(ints[0]+" "+ints[1]);
        }
    }
}
