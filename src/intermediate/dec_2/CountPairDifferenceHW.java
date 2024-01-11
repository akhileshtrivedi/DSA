package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountPairDifferenceHW {

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
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(3,5,1,2)), 4));
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(1,2,1,2)), 1));
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(2, 1, 2, 1, 2, 1, 2, 1, 2)), 1));//20

    }
}
