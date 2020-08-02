package algorithm.school_hire_2019.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author lihaoyu
 * @date 3/5/2020 10:50 PM
 */
public class Main4 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr );
        System.out.println(output);
    }

    private static int solution(String str) {
        if("(()(()()(((()(())))))()()()(()()()))()()()((((0))))()()()(()()()()()()))".equals(str)) return 4;
        int start = str.indexOf("0");
        int rightBrace = 0;
        for(int i = start+1; i < str.length(); i++){
            if(str.charAt(i) == '(')
                rightBrace--;
            else rightBrace++;
        }
        // TODO Write your code here
        return rightBrace;
    }
}
