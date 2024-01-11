package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.Collections;

public class CheckPairSum {

    private static int solveOLD(int A, ArrayList<Integer> B) {
        int N = B.size();
        System.out.println("" + B.contains(0));
        int j = 1, count = 0;
        for (int i = 0; i < N; i++) {
            if (j < B.size() && B.get(i) != B.get(j) && A == (B.get(i) + B.get(j))) {
                return 1;
            } else if (j >= B.size() && B.get(i) != B.get(0) && A == (B.get(i) + B.get(0))) {
                return 1;
            }
            j++;
        }
        return 0;
    }

    private static int solve(int A, ArrayList<Integer> B) {
        int N = B.size();

        for (int i = 0; i < N; i++) {
            int b = A-B.get(i);
            for (int j = i + 1; j < N; j++) {
                if (B.get(j) == b) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("" + solve(100, new ArrayList<Integer>(Arrays.asList(23, 52, 95, 29, 9, 47, 49, 55, 96, 4))));
        // System.out.println(""+solve(21, new ArrayList<Integer>(Arrays.asList(9, 10, 7, 10, 9, 1, 5, 1, 5))));

    }
}
