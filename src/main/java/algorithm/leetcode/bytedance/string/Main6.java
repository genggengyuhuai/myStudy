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

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if("".equals(s)) continue;

        }

        return "";
    }

    public static void main(String[] args) {

    }
}
