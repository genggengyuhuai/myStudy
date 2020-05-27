package algorithm.leetcode;

/**
 * 最长回文子串
 * @author lihaoyu
 * @date 2020/5/21 8:19 下午
 */
public class
Main5 {

    private int fun(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--; j++;
        }
        return j - i - 1;
    }


    // 中心扩展法  注意奇偶
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        int maxLen = 1, i = 0;
        for (int center = 0; center < s.length(); center++) {
            int temp1 = fun(s,center,center);
            int temp2 = fun(s, center, center+1 >= s.length() ? center : center+1);
          if( temp1 > maxLen){
              maxLen = temp1;
              i = center - temp1/2;
          }
          if( temp2 > maxLen){
              maxLen = temp2;
              i = center - temp2/2 + 1;
          }
        }
        return s.substring(i,i + maxLen);
    }

    public static void main(String[] args) {
        Main5 main5 = new Main5();
        System.out.println(main5.longestPalindrome("cbbd"));
    }
}







