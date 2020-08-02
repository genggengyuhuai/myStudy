package distribution.temp;

/**
 * @author lihaoyu
 * @date 2019/12/17 14:33
 */
public class Temp {


    public static void main(String[] args) {
        String src = "   hello world   java";
        char[] cs = src.toCharArray();
        int len = src.length(), i = 0, j = 0;
        while(i < len){
            if(cs[i] != ' '){
                cs[j++] = cs[i];
            }
            i++;
        }
        for (int i1 = 0; i1 < j; i1++) {
            System.out.print(cs[i1]);
        }


    }

}
