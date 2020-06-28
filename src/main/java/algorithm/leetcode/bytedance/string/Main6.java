package algorithm.leetcode.bytedance.string;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 * @author lihaoyu
 * @date 2020/6/28 9:50 下午
 */
public class Main6 {

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if("".equals(s) || ".".equals(s)) continue;
            if("..".equals(s) && !stack.isEmpty()){
                stack.pop();
            }else if(!"..".equals(s)){
                stack.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        if(sb.length() == 0) return "/";
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }
}
