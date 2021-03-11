package algorithm.leetcode;

/**
 *   Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：

 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * @author lihaoyu
 * @date 2020/11/15 22:12
 */
public class Main6 {

    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();
        boolean down = true;
        int curRow = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs[curRow].append(s.charAt(i));
            if(down && (curRow == numRows - 1) || !down && (curRow == 0)) down = !down;
            curRow += (down ? 1 : -1);
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) {
            res.append(sb);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(convert("ab", 1));
    }
}
