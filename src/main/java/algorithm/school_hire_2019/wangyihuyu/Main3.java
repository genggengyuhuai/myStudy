package algorithm.school_hire_2019.wangyihuyu;

import java.util.Scanner;

/**
 * 字符迷阵是一种经典的智力游戏。玩家需要在给定的矩形的字符迷阵中寻找特定的单词。
 * 在这题的规则中，单词是如下规定的：
 * 1. 在字符迷阵中选取一个字符作为单词的开头；
 * 2. 选取右方、下方、或右下45度方向作为单词的延伸方向；
 * 3. 以开头的字符，以选定的延伸方向，把连续得到的若干字符拼接在一起，则称为一个单词。
 * @author lihaoyu
 * @date 2019/11/5 16:07
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            String[] strings = new String[m];
            for (int i = 0; i < m; i++) {
                strings[i] = scanner.next();
            }
            String key = scanner.next();
            System.out.println(fun(strings,key));

        }
    }

    private static int fun(String[] strings,String key) {
        int m = strings.length;
        int n = strings[0].length();
        int count = 0;
        char [][] cs = new char[m][n];
        for (int i = 0; i < strings.length; i++) {
            for(int j = 0; j < n; j++){
                cs[i][j] = strings[i].charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        int len = key.length();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(cs[i][j] != key.charAt(0)){
                    continue;
                }
                if(j<n-len+1){
                    for(int k = 0; k < len; k++){
                        sb.append(cs[i][j+k]);
                    }
                    if(sb.toString().equals(key)){
                        count++;
                    }
                    sb.delete(0,len);
                }
                if(i < m - len +1){
                    for(int k = 0; k < len; k++){
                        sb.append(cs[i+k][j]);
                    }
                    if(sb.toString().equals(key)){
                        count++;
                    }
                    sb.delete(0,len);
                }
                if(i < m - len +1 && j<n-len+1){
                    for(int k = 0; k < len; k++){
                        sb.append(cs[i+k][j+k]);
                    }
                    if(sb.toString().equals(key)){
                        count++;
                    }
                    sb.delete(0,len);
                }
                }
            }
        return count;
    }
}
