package algorithm.leetcode;

/**
 * 单词搜索
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * @author lihaoyu
 * @date 2020/12/13 10:20 下午
 */
public class Main79 {

    private boolean[][] visited;
    private boolean res;
    private char[][] board;
    private String word;

    // 直接深搜
    private void fun(int i, int j, int len) {
        if (len == word.length()) {
            res = true;
            return;
        }
        // 如果找到了 或者 越界 或者 访问过了 ， 直接返回
        if (res || i < 0 || j < 0 || i >= visited.length || j >= visited[0].length
                || visited[i][j] || len >= word.length() || board[i][j] != word.charAt(len)) return;
        visited[i][j] = true;
        fun(i + 1, j,len+1);
        fun(i - 1, j,len+1);
        fun(i, j + 1,len+1);
        fun(i, j - 1,len+1);
        visited[i][j] = false;
    }


    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length && !res; i++) {
            for (int j = 0; j < board[0].length && !res; j++) {
                fun(i, j,0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Main79 main79 = new Main79();
        System.out.println(main79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
    }
}
