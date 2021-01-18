package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author lihaoyu
 * @date 2020/11/14 22:32
 */
public class Main12 {

    static class Node {

        int key;
        String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }
        public static String intToRoman(int num) {
            List<Node> list = new ArrayList<>();
            list.add(new Node(1000,"M"));
            list.add(new Node(900,"CM"));
            list.add(new Node(500,"D"));
            list.add(new Node(400,"CD"));
            list.add(new Node(100,"C"));
            list.add(new Node(90,"XC"));
            list.add(new Node(50,"L"));
            list.add(new Node(40,"XL"));
            list.add(new Node(10,"X"));
            list.add(new Node(9,"IX"));
            list.add(new Node(5,"V"));
            list.add(new Node(4,"IV"));
            list.add(new Node(1,"I"));
            StringBuilder res = new StringBuilder();
            while(num > 0) {
                for (Node node : list) {
                    if (num >= node.key) {
                        num -= node.key;
                        res.append(node.value);
                        break;
                    }
                }
            }
            return res.toString();
        }



    public static void main(String[] args) {
        System.out.println(intToRoman(20));
    }
}
