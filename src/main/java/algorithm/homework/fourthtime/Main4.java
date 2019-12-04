package algorithm.homework.fourthtime;

/**
 * 棋盘覆盖
 * @author lihaoyu
 * @date 2019/12/4 15:53
 */
public class Main4 {

    static int countL = 0;
    static final int MaxNum = 1 << 5;
    static int[][] board = new int[MaxNum][MaxNum];

    private static void fun(int startX, int startY, int knownX, int knownY, int size){
        if(size == 1) return;
        int t = countL++;
        size /= size;

        if(knownX < startX + size && knownY < startY + size){
            fun(startX,startY,knownX,knownY,size);
        }else{
            board[startX + size - 1][startY + size - 1] = t;
            fun(startX,startY,startX + size - 1,startY + size - 1,size);
        }

        if(knownX >= startX + size && knownY < startY + size){
            fun(startX + size,startY,knownX,knownY,size);
        }else{
        }


    }


    public static void main(String[] args) {




    }

}
