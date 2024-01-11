package intermediate.dec_21;

import java.util.Arrays;

public class SumTheDifference {
    public static int MOD = 1000000007;
    private static int solve(int[] arr) {
        int n= arr.length;
        Arrays.sort(arr);

        int min_sum = 0, max_sum = 0;
        for (int i = 0; i < n; i++)
        {
            max_sum = 2 * max_sum + arr[n - 1 - i];
            max_sum %= MOD;
            min_sum = 2 * min_sum + arr[i];
            min_sum %= MOD;
        }

        return (max_sum - min_sum + MOD)%MOD;
    }

    public static void main(String[] args) {
      int[]  A = {1, 2};
        int  []AA = {1};
        System.out.println(""+solve(A));
        System.out.println(""+solve(AA));
    }

}
