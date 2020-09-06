package interview.tecent;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * 一个大团队有 n 个人， 分成 m 个小团队    一个通知给了0号人，通知会在小组内传播，问传播完有多人收到通知
 * 输入 m,n  然后 m 行，每行是这个小团队的人员
 * 50 5
 * 2 1 2
 * 5 10 11 12 13 14
 * 2 0 1
 * 2 49 2
 * 4 6 7 8 2
 * n 在 10W 内，  m 在 500 内， 每个小组不超过100人
 * 输出  0，1，2，6，7，8，49 共 7 人
 * @author lihaoyu
 * @date 2020/9/6 7:56 下午
 */
public class Main12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        // HashMap key 是成员编号   value 是其所属的团队号
        // 0 找到团队号，然后找到小组里都有谁， 每个人的团队号放到临时容器里
        Map<Integer, Set<Integer>> N2MMap = new HashMap<>();
        Map<Integer, Set<Integer>> M2NMap = new HashMap<>();
        Set<Integer> alreadyM = new HashSet<>();
        Queue<Integer> tempM = new ArrayDeque<>();
        Set<Integer> res = new HashSet<>(m*10);
        // 先处理输入
        for (int i = 0; i < m; i++) {
            int len = in.nextInt();
            for (int j = 0; j < len; j++) {
                int temp = in.nextInt();
                if(!M2NMap.containsKey(i)) M2NMap.put(i, new HashSet<>());
                M2NMap.get(i).add(temp);
                if(!N2MMap.containsKey(temp)) N2MMap.put(temp, new HashSet<>());
                N2MMap.get(temp).add(i);
            }
        }
        // 从零号人员开始
        tempM.addAll(N2MMap.get(0));
        while(!tempM.isEmpty()){
            // 0 号人 属于 哪个组
            Integer mIndex = tempM.poll();
            // 处理过的组，跳过
            if(alreadyM.contains(mIndex)) continue;
            else alreadyM.add(mIndex);
            // 之后，当前组所有成员加入 res，并所有成员所属的组也加入
            Set<Integer> tempSet = M2NMap.get(mIndex);
            res.addAll(tempSet);
            for (Integer tempNIndex : tempSet) {
//                if(alreadyM.contains(mIndex)) continue;
//                else alreadyM.add(mIndex);
                Set<Integer> kkk = N2MMap.get(tempNIndex);;
                for (Integer integer : kkk) {
                    if(!alreadyM.contains(integer)) tempM.add(integer);
                }
            }
        }
        System.out.println(res);
    }
}














