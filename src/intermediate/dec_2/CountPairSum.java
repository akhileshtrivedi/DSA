package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountPairSum {

   private  static int getPairsCount(ArrayList<Integer> A, int B)
    {
        int n= A.size();
        HashMap<Integer, Integer> m = new HashMap<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            int a= A.get(i);
            if (m.containsKey(B - a)) {
                count += m.get(B - a) ;
                count = count % 1000000007;
            }
            if (m.containsKey(a)) {
                m.put(a, m.get(a) + 1);
            }
            else {
                m.put(a, 1);
            }
        }
        return (int)count;
    }
    //1782074850
    //782074843
    private static int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int count=0;
        for (int i = 0; i < N; i++) {
            int b = B-A.get(i);
            for (int j = i + 1; j < N; j++) {
                if (A.get(j) == b) {
                    count++;
                }
            }
        }
        return count;
    }
    private static int solveOLD(ArrayList<Integer> A, int B) {
        int N= A.size();
        int j=1, count=0;
        for (int i=0;i<N;i++){
           if(j<A.size() && A.get(i)!=A.get(j) && B==(A.get(i)+A.get(j))) {
            count++;
           } else if(j>=A.size() && A.get(i)!=A.get(0) && B==(A.get(i)+A.get(0))){
               count++;
           }
           j++;
        }
        return count;
    }
    public static void main(String[] args) {
       System.out.println(""+getPairsCount(new ArrayList<Integer>(Arrays.asList(16, 3, 3, 6, 7, 8, 17, 13, 7 )), 3));
       System.out.println(""+getPairsCount(new ArrayList<Integer>(Arrays.asList(9, 18, 17, 17, 6, 16, 13, 11, 15, 7)), 15));
       //System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2)), 3));

    }
}
