package algorithm.leetcode.bytedance.array_sort;

import java.util.LinkedList;

/**
 *   朋友圈
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * @author lihaoyu
 * @date 2020/7/5 10:43 上午
 */
public class Main8 {

    // 求连通分量
    public int findCircleNum(int[][] M) {
       // 不用判空
        int len = M.length, res = 0;
        boolean[] flags = new boolean[len];
        for (int i = 0; i < flags.length; i++) {
            if(flags[i]){
                continue;
            }
            // 广搜
            res++;
            LinkedList<Integer> list = new LinkedList<>();
            list.addLast(i);
            while(!list.isEmpty()){
                int tempIndex = list.pollFirst();
                flags[tempIndex] = true;
                for(int j = 0; j < len; j++)
                    // 不能加自己
                    if(!flags[j] && j != tempIndex && M[tempIndex][j] == 1)
                        list.addLast(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main8 main8 = new Main8();
        System.out.println(main8.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

    }
}
