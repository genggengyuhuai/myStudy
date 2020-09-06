package interview.tecent;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * N 个字符串， 求出现前 K多和前 K少的字符串，保证 K 合法
 * 输出， 前 K行是前 K 多， 按照出现次数从大到小，若出现次数相同，按字典序从小到大
 * 输出， 后 K行是前 K 少， 按照出现次数从少到多，若出现次数相同，按字典序从小到大
 *
 * @author lihaoyu
 * @date 2020/9/6 7:56 下午
 */
public class Main13 {

    // 自定义一个数据结构
    static class Node {
        String value;
        int count;

        Node(String value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return value + " " + count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), K = scanner.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String source = scanner.next();
            Integer count = map.getOrDefault(source, 0);
            map.put(source, count + 1);
        }
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        map.forEach((k, v) -> list1.add(new Node(k, v)));
        map.forEach((k, v) -> list2.add(new Node(k, v)));
        list1.sort((o1, o2) -> {
            if (o1.count != o2.count) return o1.count - o2.count;
            return o1.value.compareTo(o2.value);
        });
        list2.sort((o1, o2) -> {
            if (o1.count != o2.count) return o2.count - o1.count;
            return o1.value.compareTo(o2.value);
        });
        for (int i = 0; i < K; i++) {
            System.out.println(list2.get(i));
        }
        for (int i = 0; i < K; i++) {
            System.out.println(list1.get(i));
        }
    }


}
