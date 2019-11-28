package algorithm.leetcode.tencent;

/**
 * 最长回文字串
 * @author lihaoyu
 * @date 2019/11/28 19:58
 */
public class Main5 {

    private static String fun(String s, int i, int j){
        while(i >= 0 && j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else{
                break;
            }
        }
        return s.substring(i+1,j);
    }

    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            String fun1 = fun(s, i, i);
            if(fun1.length() > maxLen){
                res = fun1;
                maxLen = fun1.length();
            }
            String fun2 = fun(s, i, i + 1);
            if(fun2.length() > maxLen){
                res = fun2;
                maxLen = fun2.length();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Main5().longestPalindrome("babad"));
    }
}
