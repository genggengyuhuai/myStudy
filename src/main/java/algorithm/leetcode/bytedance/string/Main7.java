package algorithm.leetcode.bytedance.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * @author lihaoyu
 * @date 2020/6/28 9:50 下午
 */
public class Main7 {

    private String str;

    private void fun(List<String> list,  int i , int count, StringBuilder sb){
        if(i == str.length() && count == 4){
            list.add(sb.toString());
            return;
        }

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s == null) return list;
        fun(list,0,0,new StringBuilder());
        return list;
    }


    public static void main(String[] args) {

    }
}
