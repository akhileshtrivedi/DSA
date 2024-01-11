package intermediate.nov_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {
    private static int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            mp.put(A.get(i), mp.get(A.get(i)) == null ? 1 : mp.get(A.get(i)) + 1);
        }
        for (int i = 0; i < A.size(); i++) {
            if((mp.get(A.get(i)) >= 2) ){
                return A.get(i);
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(10, 5, 3, 4, 3, 5, 6))));
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(6, 10, 5, 4, 9, 120))));
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16, 3 ))));

    }
}
