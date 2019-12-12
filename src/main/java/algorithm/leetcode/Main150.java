package algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2019/12/12 16:19
 */
public class Main150 {


    public int evalRPN(String[] tokens) {
        LinkedList<Integer> list = new LinkedList<>();
        List<String> ops = Arrays.asList("+", "-", "*", "/");
        int number1;
        int number2;
        for (String token : tokens) {
            if (ops.contains(token)) {
                number1 = list.pollLast();
                number2 = list.pollLast();
                switch (token) {
                    case "+":
                        list.addLast(number2 + number1);
                        break;
                    case "-":
                        list.addLast(number2 - number1);
                        break;
                    case "*":
                        list.addLast(number2 * number1);
                        break;
                    case "/":
                        list.addLast(number2 / number1);
                        break;
                    default:
                        break;
                }
            } else {
                list.addLast(Integer.parseInt(token));
            }
        }
        return list.get(0);
    }


    public static void main(String[] args) {

    }
}
