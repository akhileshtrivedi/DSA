package intermediate.nov_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {
    private static int solve(ArrayList<Integer> A) {
        Integer[] arr = new Integer[A.size()];
        arr = A.toArray(arr);
        Set<Long> hs = new HashSet<Long>();
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 || sum == 0 || hs.contains(sum))
                return 1;
            hs.add(sum);
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5))));
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(-1,1))));
    }
}
