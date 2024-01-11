package intermediate.nov_30;

import java.util.*;

public class CountUniqueElementsHW {
    private static int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> mp = new HashMap();
        for (int i = 0; i < A.size(); i++) {
            mp.put(A.get(i), mp.get(A.get(i)) == null ? 1 : mp.get(A.get(i)) + 1);

        }
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if ((mp.get(A.get(i)) == 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(13, 15, 13, 2, 9, 3, 10, 10, 20, 13))));
    }
}
