package interview.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 第三题  直接深搜  80%   说是数组越界？？？
 *  自测： 3 1 1 1 1 20 2 2 30 3 3 40 1
 * @author lihaoyu
 * @date 2020/4/15 19:39
 */
public class Main2 {

    private static class Node {
        int flag; // 标号
        int stackSize; // 栈大小
        List<Integer> list; // 调用链

        public Node(int flag, int stackSize) {
            this.flag = flag;
            this.stackSize = stackSize;
            this.list = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return flag == node.flag;
        }

        @Override
        public int hashCode() {
            return flag;
        }
    }

    static int maxRes = 0;
    static Map<Integer, Node> map = new HashMap<>(128);
    // 中间结果
    static List<Node> temp = new ArrayList<>();
    static int errorCode = 0;

    // 从 flag 号开始查找调用链
    private static void fun(int flag) {
        // 出现未知栈
        if (!map.containsKey(flag)) {
            errorCode = 1;
            return;
        }
        // 出现循环
        if (temp.contains(new Node(flag, 2020))) {
            errorCode = 2;
            return;
        }
        Node node = map.get(flag);
        temp.add(node);
        // 到达终点
        if (node.list.size() == 0) {
            int tempSum = 0;
            for (Node node1 : temp) {
                tempSum += node1.stackSize;
            }
            maxRes = Math.max(maxRes, tempSum);
            return;
        }
        // 否则深搜
        for (Integer integer : node.list) {
            fun(integer);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 静态变量重新赋值
            maxRes = 0;
            map = new HashMap<>(128);
            temp = new ArrayList<>();

            int N = scanner.nextInt();
            int[] counts = new int[N];
            for (int i = 0; i < N; i++) {
                counts[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                int flag = scanner.nextInt();  // 标号
                Node temp = new Node(flag, scanner.nextInt());
                for (int j = 0; j < counts[i]; j++) {
                    temp.list.add(scanner.nextInt());
                }
                map.put(flag, temp);
            }
            // 深度遍历，从所有节点开始
            map.forEach((k, v) -> {
                temp.clear();
                fun(k);
            });
            if(errorCode == 1)System.out.println("NA");
            else if(errorCode == 2)System.out.println("R");
            else System.out.println(maxRes);
        }
    }
}
