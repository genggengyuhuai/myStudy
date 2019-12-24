package algorithm.school_hire_2019.bytedance;

import java.util.Scanner;

/**
 * 万万没想到之聪明的编辑
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 * @author lihaoyu
 * @date 2019/12/24 12:01
 */
public class Main1 {

    private static String fun(String string){
        char[] chars = string.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            int len = res.length();
            if(len >= 2 && chars[i] == res.charAt(len - 1) && chars[i] == res.charAt(len-2)){
                // 不加进去
                continue;
            }
            if(len >= 3 && chars[i] == res.charAt(len-1) && res.charAt(len-2) == res.charAt(len-3)){
                // 不加进去
                continue;
            }
            res.append(chars[i]);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.println(fun(scanner.next()));
        }
    }
}
