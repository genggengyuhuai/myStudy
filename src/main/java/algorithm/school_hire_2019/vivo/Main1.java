package algorithm.school_hire_2019.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环    朴素写法
 * @author lihaoyu
 * @date 3/5/2020 6:11 PM
 */
public class Main1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int[] input = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {
        int N = input[0], M = input[1];
        List<Integer> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int index = 0, count = 0;
        while(!list.isEmpty()){
            if(index >= list.size()){
                index %= list.size();
            }
            count++;
            if(count % M == 0){
                res.add(list.remove(index));
                continue;
            }
            index++;
        }
        // TODO Write your code here
        StringBuilder sb = new StringBuilder();
        res.forEach(s-> sb.append(s).append(" "));
        return sb.toString();
    }

}
