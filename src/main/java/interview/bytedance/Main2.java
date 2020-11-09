package interview.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * 转正加面 11.6 号   廖宝华
 * @author lihaoyu
 * @date 2020/11/6 5:30 下午
 */
public class Main2 {

    // 查找子串包含(有重复字符).
    private static int fun(String pattern, String target) {
        Map<Character, Integer> src = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // 保存源字符串 key是字符，value是出现次数
        for (int i = 0; i < pattern.length(); i++) {
            src.put(pattern.charAt(i), src.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        // count 是窗口满足了多少种字符， 如果等于 src.size 说明找到了
        int left = 0, right = 0, count = 0;
        while (right < target.length()) {
            char c = target.charAt(right);
            right++;
            // 只有源字符串有，才加到窗口里
            if (src.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 当前字符个数满足了，加 count
                if (window.get(c).equals(src.get(c))) {
                    count++;
                }
            }
            // 全部满足了，直接返回
            if (count == src.size()) {
                return left;
            }
            // 窗口过大则收缩
            if (right - left >= pattern.length()) {
                char d = target.charAt(left);
                // 把 count 减一下
                if(src.containsKey(d)){
                    if (window.get(d).equals(src.get(d)))
                        count--;
                    window.put(d,window.get(d)-1);
                }
                left++;
            }
            // 继续查找
        }
        // 最后也没找到
        return -1;
    }


    public static void main(String[] args) {


        System.out.println(fun("abcaa", "asscabaazc"));
    }
}

