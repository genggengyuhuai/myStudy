package algorithm.basic_algorithm.recursivebacktrack;

import java.util.ArrayList;

/**
 * @author lihaoyu
 * @date 2019/10/14 19:07
 */
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class MazeTest {

   private int[][] maze = new int[][]{
           {1,1,1,1},
           {1,1,1,0},
           {1,0,0,0},
           {1,1,1,1}
   };

    private boolean[][] visited = new boolean[4][4];

    private boolean canArrive(int i, int j){
       return maze[i][j] == 1 && !visited[i][j];
    }

    private ArrayList<Node> temp = new ArrayList<>();

    private ArrayList<ArrayList<Node>> list = new ArrayList<>();

    private void fun(int i, int j){
        if(!canArrive(i,j)) return;
        visited[i][j] = true;
        temp.add(new Node(i,j));
        if(i == 3 && j == 3) {
            ArrayList<Node> res = new ArrayList<>();
            temp.forEach(s -> res.add(s));
            list.add(res);
        }
        if( j + 1< 4 ){
            fun(i,j+1);
        }
        if( i + 1< 4 ){
            fun(i+1,j);
        }
        if( j - 1>= 0 ){
            fun(i,j-1);
        }
        if( i - 1>= 0 ){
            fun(i-1,j);
        }
        visited[i][j] = false;
        temp.remove(temp.size()-1);
        return;
    }

    public static void main(String[] args) {
        MazeTest test = new MazeTest();
        test.fun(0,0);
        for (ArrayList<Node> nodes : test.list) {
            System.out.println(nodes);
        }

    }
}
