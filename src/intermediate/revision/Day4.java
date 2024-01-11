package intermediate.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Day4 {
    private static int solve(ArrayList<Integer> A) {
        int max = A.get(0);
        int len = A.size();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (A.get(i) == max) {
                count++;
            } else if (A.get(i) > max) {
                count = 1;
                max = A.get(i);
            }
        }
        return len - count;

    }
    private static int solve(ArrayList<Integer> A, int B) {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < A.size(); ++i) {
            int temp = B - A.get(i);
            if (s.contains(temp)) {
                return 1;
            }
            s.add(A.get(i));
        }
        return 0;
    }
    public static void main(String[] args) {
      //  System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(1,2,2,2,2,5,1))));
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(1,2,3,4)),5));
    }
}
