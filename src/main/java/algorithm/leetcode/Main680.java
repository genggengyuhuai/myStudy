package algorithm.leetcode;

/**
 *
 * @author lihaoyu
 * @date 2020/5/21 4:16 下午
 */
public class Main680 {

    private boolean fun(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;end--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        boolean flag = true;
        while(left < right){
            if(!flag) return false;
            if(s.charAt(left) == s.charAt(right)) {
                left++; right--; continue;
            }
            return fun(s,left+1,right) | fun(s, left, right-1);
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
