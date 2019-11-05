package algorithm.school_hire_2019.weipinhui;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/4 10:51
 */
public class Main1 {

    private static boolean isLeftBrace(char c) {
        return c == '['  || c == '(';
    }
    private static boolean isRightBrace(char c) {
        return c == ']'  || c == ')';
    }
    private static boolean isBrace(char c) {
        return isLeftBrace(c) || isRightBrace(c);
    }
    private static boolean match(char left, char right){
        return (left == '(' && right == ')') ||(left == '[' && right == ']');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (!isBrace(c)) {
                continue;
            }
            if(isLeftBrace(c)){
                list.addLast(c);
                continue;
            }
            // c 一定是右括号
            if(list.isEmpty()){
                System.out.println(false);
                return;
            }
            char leftBrace = list.pollLast();
            if(!match(leftBrace, c)){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }


}
