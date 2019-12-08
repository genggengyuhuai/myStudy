package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 电话号码上的数字
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author lihaoyu
 * @date 2019/12/6 18:01
 */
public class Main17 {

    // 递归
    public List<String> letterCombinations(String digits) {
        List<List<Character>> sourceList = new ArrayList<>();
        sourceList.add(Arrays.asList());
        sourceList.add(Arrays.asList('a','b','c'));
        sourceList.add(Arrays.asList('d','e','f'));
        sourceList.add(Arrays.asList('g','h','i'));
        sourceList.add(Arrays.asList('j','k','l'));
        sourceList.add(Arrays.asList('m','n','o'));
        sourceList.add(Arrays.asList('p','q','r','s'));
        sourceList.add(Arrays.asList('t','u','v'));
        sourceList.add(Arrays.asList('w','x','y','z'));
        List<String> resList = new ArrayList<>();
        if(digits == null || digits.length() == 0) return resList;
        fun(sourceList, resList, digits, 0, new StringBuilder());
        System.out.println(resList);
        return resList;
    }

    private static void fun(List<List<Character>> sourceList, List<String> resList,
                            String digits,int i, StringBuilder sb){
        if(i == digits.length()){
            resList.add(sb.toString());
            return;
        }
        while(digits.charAt(i) == '1'){
            i++;
        }
        for(int j = 0; j < sourceList.get(digits.charAt(i)-'1').size(); j++){
            sb.append(sourceList.get(digits.charAt(i)-'1').get(j));
            fun(sourceList,resList,digits,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public static void main(String[] args) {
        new Main17().letterCombinations("355");
    }
}
