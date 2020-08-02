package algorithm.homework.secondtime;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/11 20:28
 */
public class Main8 {

    static void MakeTheMinSumDif(int a[],int b[],int n)
    {
        if(SumArray(a,n)<SumArray(b,n))
        {
            int[] temp = a;
            a = b;
            b = temp;
        }
        boolean isswap = true;
        while (isswap)
        {
            isswap = false;
            for (int i = 0; i < n; ++i)
            {
                for (int j = 0; j < n; ++j)
                {
                    int diff = SumArray(a,n)-SumArray(b,n);
                    int value = a[i] - b[j];
                    if(value < diff && value > 0)
                    {
                        isswap = true;
                        int temp = a[i];
                        a[i] = b[j];
                        b[j] = temp;
                    }
                }
            }
        }
        System.out.println(SumArray(a,n)-SumArray(b,n));
    }

    private static int SumArray(int[] a,int n){
        int sum1 = 0;
        for(int i = 0; i < a.length; i++){
            sum1 += a[i];
        }
        return sum1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = scanner.nextInt();
        scanner.nextLine();
        for(int mm = 0; mm < caseNumber; mm++){


            String line1 = scanner.nextLine();
            String[] split1 = line1.split("( )+");

//            scanner.nextLine();
            String line2 = scanner.nextLine();
            String[] split2 = line2.split("( )+");

            int[] a = new int[split1.length];
            int[] b = new int[split1.length];

            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(split1[i]);
                b[i] = Integer.parseInt(split2[i]);
            }

            MakeTheMinSumDif(a,b,a.length);

        }








    }
}
