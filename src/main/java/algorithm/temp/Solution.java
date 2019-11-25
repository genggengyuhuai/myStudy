package algorithm.temp;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public ArrayList<ArrayList<Integer> > fun(int sum) {
        int temp = 0, x = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum <= 0){
            return res;
        }
        for(int i = 1;i*(i+1)/2 <= sum;i++){
            // i 是项数
            if(2*sum % i != 0){
                continue;
            }
            temp = 2*sum / i;
            if(((temp - i + 1) & 1) == 0){
                //  x是序列起始值
                x = (temp - i + 1) / 2;
                ArrayList<Integer> tempList = new ArrayList<>();
                for(int j = x; j < x+i;j++){
                    tempList.add(j);
                }
                if(tempList.size() > 1){
                    res.add(tempList);
                }
            }

        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
Solution solution = new Solution();
        System.out.println(solution.fun(100));
    }
}