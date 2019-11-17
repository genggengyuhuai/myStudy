package algorithm.school_hire_2019.xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 *  小米	计算原子的个数	87	24.68%
 * @author lihaoyu
 * @date 2019/11/16 10:27
 */
public class Main30 {
    private static boolean isNumber(String string){
        return string.charAt(0) >= '0' && string.charAt(0) <= '9';
    }

    private static List<String> transform(String src) {
        Map<String, Integer> map = new TreeMap<>();
        Stack<String> stack = new Stack<>();
        char[] cs = src.toCharArray();
        List<String> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < cs.length) {
            if (cs[i] == '(' || cs[i] == ')') {
                list.add(cs[i] + "");
                if (cs[i] == '(') {
                    stack.push(cs[i] + "");
                } else {
                    // 反括号
                    while(true){
                        String pop = stack.pop();
                        if("(".equals(pop)){
                            break;
                        }
                        String temp = null;
                        Integer number = null;
                        if(isNumber(pop)){
                            number = Integer.parseInt(pop);
                            temp = stack.pop();
                        }else{
                            temp = pop;
                        }

                        if(number == null){
                            number = 1;
                        }
                        Integer orDefault = map.getOrDefault(temp, 0);
                        map.put(temp,number+orDefault);
                    }
                }
                i++;
                continue;
            }

            if (cs[i] >= '0' && cs[i] <= '9') {
                j = i;
                while (j < cs.length && (cs[j] >= '0' && cs[j] <= '9')) {
                    j++;
                }
            } else if (cs[i] >= 'A' && cs[i] <= 'Z') {
                j = i + 1;
                while (j < cs.length && (cs[j] >= 'a' && cs[j] <= 'z')) {
                    j++;
                }
            }
            list.add(String.copyValueOf(cs, i, j - i));
            stack.push(String.copyValueOf(cs, i, j - i));
            i = j;
        }
        System.out.println(map);
        return list;

    }

    private static void fun() {

    }

    public static void main(String[] args) {
        List<String> transform = transform("(Kgg4(ON(SO3)2)2)");
        System.out.println(transform);
    }
}
