package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * @author lihaoyu
 * @date 2020/5/17 2:38 下午
 */
public class Main210 {

    // 就是拓扑排序
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] res = new int[numCourses];
            int index = 0;
            // 根据输入创建临接表和逆临接表
            List<List<Integer>> linjie = new ArrayList<>(numCourses);
            List<List<Integer>> nilinjie = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                linjie.add(new ArrayList<>());
                nilinjie.add(new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                linjie.get(prerequisite[1]).add(prerequisite[0]);
                nilinjie.get(prerequisite[0]).add(prerequisite[1]);
            }

            // 拓扑排序,不断找入度为0的
            Set<Integer> set = new HashSet<>(numCourses);  // 防止重复
            while(set.size() != numCourses) {
                boolean flag = false;
                for (int i = 0; i < nilinjie.size(); i++) {
                    if (!set.contains(i) && nilinjie.get(i).isEmpty()) {
                        flag = true;
                        res[index++] = i;
                        // 找到了。再去临接表里找其出度，把出度的入度（对应删除）
                        for (int j = 0; j < linjie.get(i).size(); j++) {
                            int temp = linjie.get(i).get(j);
                            nilinjie.get(temp).remove(new Integer(i));
                        }
                        set.add(i);
                    }
                }
                if(!flag) break;
            }
            if(set.size() != numCourses) return new int[0];
            return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
