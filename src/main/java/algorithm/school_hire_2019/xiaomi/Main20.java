package algorithm.school_hire_2019.xiaomi;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 数值序列中包含2~16进制整数，如果序列中有一个数，
 * 与序列中其他任何一个数大小都不相等，则这个数叫做“异数”。请找出给定数值序列中所有的“异数”.
 * @author lihaoyu
 * @date 2019/11/12 15:31
 */
public class Main20 {

    private static class Node{
        String string;
        int value;

        public Node(String string, int value) {
            this.string = string;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Node,Integer> map = new LinkedHashMap<>(10000);
        while(scanner.hasNext()){
            String next = scanner.next();
            if("END".equals(next)){
                Set<Node> set = new HashSet<>();
                for (Map.Entry<Node, Integer> nodeIntegerEntry : map.entrySet()) {
                    if(nodeIntegerEntry.getValue().intValue() != 1){
                        set.add(nodeIntegerEntry.getKey());
                    }
                }
                for (Node node : set) {
                    map.remove(node);
                }
                if(map.isEmpty()){
                    System.out.println("None");
                }else {
                    for (Map.Entry<Node, Integer> nodeIntegerEntry : map.entrySet()) {
                        System.out.println(nodeIntegerEntry.getKey().string);
                    }
                }
                break;
            }
            String[] split = next.split("#");
            int value = Integer.parseInt(split[1],Integer.parseInt(split[0]));
            Node tempNode = new Node(next,value);
            Integer temp = map.get(tempNode);
            if(temp == null){
                map.put(tempNode, 1);
            }else{
                map.put(tempNode, temp+1);
            }
        }


    }
}
