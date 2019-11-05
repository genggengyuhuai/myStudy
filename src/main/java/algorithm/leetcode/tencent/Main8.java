package algorithm.leetcode.tencent;

/** 字符串转换整数 (atoi)
 * @author lihaoyu
 * @date 2019/11/4 11:09
 */
public class Main8 {

    private static boolean isDigital(char c){
        return c >= '0' && c <= '9';
    }

    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        if(str == null || str.length() == 0){
            return 0;
        }
        // 0 是没有符号
        int zhengshu = 1;

        char first = str.charAt(0);
        if(!isDigital(first) && first != '+' && first != '-') {
            return 0;
        }
        else if(isDigital(first)){
            zhengshu = 0;
        }
        else {
            zhengshu = first == '+' ? 1 : -1;
        }
        int i;
        for(i = 1; i < str.length(); i++){
            if(isDigital(str.charAt(i))){
                continue;
            }
            break;
        }
        String num = str.substring(0, i);
        if(zhengshu == 0 && num.length() == 0 || zhengshu != 0 && num.length() == 1){
            return 0;
        }
        int res;
        try {
            res = Integer.parseInt(num);
        }catch (Exception e){
            if(zhengshu == 1 || zhengshu == 0){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main8 main8 = new Main8();
        System.out.println(main8.myAtoi("  +"));
    }

}
