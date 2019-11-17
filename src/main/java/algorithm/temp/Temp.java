package algorithm.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lihaoyu
 * @date 2019/11/16 22:39
 */
public class Temp extends Thread{

    private static boolean isNumber(String string){
        return string.charAt(0) >= '0' && string.charAt(0) <= '9';
    }

    private static boolean isPrefer(String op1, String op2){
        if("#".equals(op1)){
            return false;
        }
        if("+".equals(op1) || "-".equals(op1)){
            return "#".equals(op2);
        }
        if("*".equals(op1) || "/".equals(op1)){
            return "+".equals(op2) || "-".equals(op2) || "#".equals(op2);
        }
        return false;
    }

    public static void main(String[] args) {
        Thread temp2 =  new Temp();
        System.out.println(temp2.getClass().getSuperclass().getName());
        System.out.println();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("+");
        list.add("2");
        list.add("*");
        list.add("3");
        list.add("#");
        Stack<Integer> nums = new Stack<>();
        Stack<String> ops = new Stack<>();
        ops.push("#");
        for (String s : list) {
            if(isNumber(s)){
                nums.push(Integer.parseInt(s));
                continue;
            }
            if(isPrefer(s,ops.peek())){
                ops.push(s);
                continue;
            }
            while(isPrefer(ops.peek(),s)){
                String op = ops.pop();
                int temp = 0;
                int num1 = nums.pop(), num2 = nums.pop();
                switch (op) {
                    case "+":temp =  num2 + num1;break;
                    case "-":temp =  num2 - num1;break;
                    case "*":temp = num2 * num1; break;
                    case "/":temp = num2 / num1; break;
                    default:
                        System.out.println("Error");
                }
                nums.push(temp);
            }
        }
        System.out.println(nums);
    }
}
