package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PairWithGivenDifferenceHW {
    private static int solve(ArrayList<Integer> A, int B) {
        int n= A.size();
        HashMap<Integer, Integer> m = new HashMap<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            int a= A.get(i);
            if (m.containsKey(B + a)) {
                count += m.get(B + a);
                count = count % 1000000007;
            }
            if (m.containsKey(a-B)) {
                count += m.get(a-B);
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
    public static void main(String[] args) {
       // System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(5, 10, 3, 2, 50, 80)), 78));
      //  System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(-10, 20)), 30));
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList( -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322)), 369));
        //System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(                     169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297)), 369));

    }
}
