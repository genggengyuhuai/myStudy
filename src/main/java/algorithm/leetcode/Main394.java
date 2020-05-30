package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 字符串解码    有点像表达式计算的弱化版
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * @author lihaoyu
 * @date 2020/5/28 12:40 下午
 */
public class Main394 {

    // 用来处理数字的，返回数字长度
    private int isNumber(String s, int start){
        int end = start;
        while(end < s.length() && s.charAt(end) >= '0' && s.charAt(end) <= '9') end++;
        return end-start;
    }

    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        int index = 0;
        Stack<String> stack = new Stack<>();
        while(index < s.length()){
            if(s.charAt(index) == '[' || Character.isLetter(s.charAt(index))){
                stack.add(String.valueOf(s.charAt(index)));
                index++;
            }else if(s.charAt(index) == ']'){
                // 出栈，直到遇到 [
                StringBuilder temp = new StringBuilder();
                List<String> list = new ArrayList<>();
                String tempStr;
                while(!((tempStr = stack.pop()).equals("["))){
                    list.add(tempStr);
                }
                // 别忘反转
                Collections.reverse(list);
                list.forEach(temp::append);
                // 最后再出栈一下，是数字
                int count = Integer.parseInt(stack.pop());
                StringBuilder tempRes = new StringBuilder(temp.length() * count);
                for (int i = 0; i < count; i++) {
                    tempRes.append(temp);
                }
                // 压回去
                stack.add(tempRes.toString());
                index++;
            }else{ // 是数字
                int len = isNumber(s, index);
                stack.add(s.substring(index, index + len));
                index = index + len;
            }
        }
        StringBuilder res = new StringBuilder(s.length() * 3);
        for (int i = 0; i < stack.size(); i++) {
            res.append(stack.elementAt(i));
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Main394 main394 = new Main394();
        System.out.println(main394.decodeString("2[2[2[ab]cd]ef]"));
    }
}
