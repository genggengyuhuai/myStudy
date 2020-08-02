package algorithm.basic_algorithm.recursive_backtrack;

/**
 * @author lihaoyu
 * @date 2019/10/9 11:14
 */
public class EightQueenTest {

    private void fun(int[] queens, int k){
        if(k == 8) {
            print(queens);
            return;
        }
        for(int i = 0; i < 8; i++){
            boolean flag = true;
            queens[k] = i;
            for(int j = 0; j < k; j++){
                if( queens[j] == queens[k] || Math.abs(queens[k] - queens[j]) == (k - j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                fun(queens,k+1);
            }
        }
    }

    private void print(int[] a){
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        EightQueenTest test = new EightQueenTest();
        test.fun(new int[8],0);
    }


}
