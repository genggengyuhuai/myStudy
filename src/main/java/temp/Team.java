package temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2020/5/15 5:43 下午
 */
public class Team {

    String name;

    public Team(String name, List<Team> list) {
        this.name = name;
        if(list != null) list.add(this);
    }


    public static void main(String[] args) {
        List<Team> list = new ArrayList<>();
        new Team("test1",list);
        new Team("test2",list);
        new Team("test3",list);
        System.out.println(list);
    }
}
