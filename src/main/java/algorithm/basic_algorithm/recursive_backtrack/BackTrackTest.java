package algorithm.basic_algorithm.recursive_backtrack;

import java.util.ArrayList;

/**
 * @author lihaoyu
 * @date 2019/10/19 23:17
 */
public class BackTrackTest {

    public static void fun(ArrayList<ArrayList<Integer>> paramList, int i,
                           ArrayList<ArrayList<Integer>> resList, ArrayList<Integer> tempList){
            if(i == paramList.size()){
                resList.add(new ArrayList<>(tempList));
                return;
            }
            for(int index = 0; index < paramList.get(i).size(); index++){
                tempList.add(paramList.get(i).get(index));
                fun(paramList, i+1, resList, tempList);
                tempList.remove(tempList.size() - 1);
            }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> paramList = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        paramList.add(new ArrayList<>(temp));
        temp.clear();
        temp.add(4);
        temp.add(5);
        paramList.add(new ArrayList<>(temp));
        temp.clear();
        temp.add(6);
        temp.add(7);
        temp.add(8);
        paramList.add(new ArrayList<>(temp));
        temp.clear();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        fun(paramList,0,res,temp);
        System.out.println();
    }
}
