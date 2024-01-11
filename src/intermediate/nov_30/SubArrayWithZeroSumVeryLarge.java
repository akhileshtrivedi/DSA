package intermediate.nov_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSumVeryLarge {
    public static int solveNew(ArrayList<Integer> A) {
        int k=5;
        int n=A.size();
        Integer[] arr = new Integer[n];

        arr = A.toArray(arr);
        int mod[] = new int[k];
        Arrays.fill(mod, 0);
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            mod[((cumSum % k) + k) % k]++;
        }
        int result = 0;

        for (int i = 0; i < k; i++)
            if (mod[i] > 1)
                result += (mod[i] * (mod[i] - 1)) / 2;

        result += mod[0];

        return result;
    }
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
    private static int solve0(ArrayList<Integer> A) {
        int n=A.size();
        Integer[] arr =new Integer[n];
        arr = A.toArray(arr);
        int count = 0;
        int[] v = new int[n + 1];

        for (int i = 0; i < n; i++)
            v[arr[i]] = i;

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {

            maximum = Math.max(maximum, v[i]);

            minimum = Math.min(minimum, v[i]);

            if (maximum - minimum < i)
                count = count + 1;
        }

        return count;

    }

    public static void main(String[] args) {
       // System.out.println("" + solve0(new ArrayList<Integer>(Arrays.asList(1, -1, -2, 2))));
        System.out.println("" + solve0(new ArrayList<Integer>(Arrays.asList(4, 1, 3, 2))));
       // System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(-1, 2, -1))));
    }
}
