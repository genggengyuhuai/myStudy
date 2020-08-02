package algorithm.contest.second;

/**
 * @author lihaoyu
 * @date 2019/10/17 11:30
 */
public class Main4 {

    private static int MAX = 100000;

  private static boolean[] primes = new boolean[MAX+1];

  private static void calPrimes(){
      for(int i = 0; i < MAX; i++){
          primes[i] = true;
      }
      for(int i = 2; i <= MAX; i++){
          for(int j = 1; j * i <= MAX; j++){
              primes[j*i] = false;
          }
      }

  }

    public static void main(String[] args) {

    }


}
