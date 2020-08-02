package algorithm.leetcode.tencent;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * @author lihaoyu
 * @date 2019/12/20 11:23
 */
public class Main13 {

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>(256);
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        int res = 0;
        for(int i = 0; i < s.length();){
            if( i < s.length() - 1 && map.containsKey(s.substring(i,i+2))){
                res += map.get(s.substring(i,i+2));
                i += 2;
            }else{
                res += map.get(s.substring(i,i+1));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
