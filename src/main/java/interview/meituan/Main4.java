package interview.meituan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 5 5 3
 * 1 1 2 3 1
 * 1 4
 * 2 4
 * 3 4
 * 4 5
 * 4 3
 * @author lihaoyu
 * @date 3/12/2020 8:52 PM
 */
public class Main4 {

    private static class Node{
        int index;  // 从 1 到 N
        List<Node> linjie = new ArrayList<>();
        int a_i;  // 拥有原材料的种类号

        int res;
        Set<Integer> set = new HashSet<>();

        public Node(int index, int a_i) {
            this.index = index;
            this.a_i = a_i;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 40; i++) {
            System.out.print(".");
        }
    }
}
