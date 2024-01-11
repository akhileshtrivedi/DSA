package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int solveOLD(ArrayList<Integer> A, int B) {
        int nums = A.size();
        if (nums < 1 || nums >= 50001) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums; i++) {
            int sum = 0;
            for (int j = i; j < nums; j++) {
                if (A.get(j) < -1000 || A.get(j) >= 1001) {
                    return 0;
                }
                sum += A.get(j);

                if (sum == B)
                    count++;
            }
        }
        return count;
    }

    private static int solve(ArrayList<Integer> A, int B) {
        int nums = A.size();
        if (nums < 1 || nums >= 50001) {
            return 0;
        }

        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums; i++) {
            if (A.get(i) < -1000 || A.get(i) >= 1001) {
                return 0;
            }
            sum += A.get(i);
            if (sum == B) {
                count++;
            }
            if (map.containsKey(sum - B)) {
                count += map.get(sum - B);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(1, 0, 1)), 1));
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(0, 0, 0)), 0));
        // System.out.println("" + solveOLD(new ArrayList<Integer>(Arrays.asList(13, 9, 19, -9, -19, 14, -15)), 15));
        // System.out.println("" + solveOLD(new ArrayList<Integer>(Arrays.asList(-2, 16, -12, 5, 7, -1, 2, 12, 11)), 17));
    }
}
