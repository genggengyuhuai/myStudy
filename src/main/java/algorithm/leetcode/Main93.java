package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main93 {

   /**
    * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
    *
    * 示例:
    *
    * 输入: "25525511135"
    * 输出: ["255.255.11.135", "255.255.111.35"]
    *
    * k最大4个，i是遍历到string的第i个字符
    *
    * @author Lihaoyu
    * @date 2019/11/8 13:49
    */
   private static void fun(String string, int k, int i, StringBuilder sb, List<String> res){
        if(k == 4){
            if(i == string.length()) {
                res.add(sb.toString());
            }
            return;
        }
        if(i<string.length()){
            sb.append(string, i, i+1);
            if(k != 3)
            sb.append(".");
            fun(string,k+1,i+1,sb,res);
            sb.delete(k+i,k+i+2);
        }
        if(i+1 < string.length() && string.charAt(i) == '0'){
            return;
        }
        if(i+1 < string.length()){
            sb.append(string, i, i+2);
            if(k != 3)
            sb.append(".");
            fun(string,k+1,i+2,sb,res);
            sb.delete(k+i,k+i+3);
        }
        if(i + 2 < string.length() && Integer.parseInt(string.substring(i,i+3)) <= 255){
            sb.append(string, i, i+3);
            if(k != 3)
            sb.append(".");
            fun(string,k+1,i+3,sb,res);
            sb.delete(k+i,k+i+4);
        }
    }
    public static void main(String[] args) {

        // 19216801   转换成 192.168.0.1    19.216.80.1
        // 长度 4 - 12


        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String string = "192100";
        fun(string, 0,0,sb,res);
        Set<String> resSet = new HashSet<>();
        System.out.println(res);
    }
}
