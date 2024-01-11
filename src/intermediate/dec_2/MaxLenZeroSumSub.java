package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaxLenZeroSumSub {
   private static int maxLen(ArrayList<Integer> A)
    {
        Integer[] arr = new Integer[A.size()];
        arr =A.toArray(arr);
        HashMap<Long, Integer> hM
                = new HashMap<Long, Integer>();

        long sum = 0;
        int max_len = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0)
                max_len = i + 1;

            Integer prev_i = hM.get(sum);

            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else
                hM.put(sum, i);
        }
        System.out.println(hM);
        return max_len;
    }

    public int solve(ArrayList<Integer> A) {
       int N= A.size();
        Integer[] arr = new Integer[N];
        arr =A.toArray(arr);
        int max_len = 0;
        for (int i = 0; i < N; i++) {
            int curr_sum = 0;
            for (int j = i; j < N; j++) {
                curr_sum += arr[j];
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }
    public static void main(String[] args) {
        System.out.println(""+maxLen(new ArrayList<Integer>(Arrays.asList(1, -2, 1, 2, -2,1,1,1,1,1,5))));
       // System.out.println(""+maxLen(new ArrayList<Integer>(Arrays.asList(1, -2, 1, 2))));
       // System.out.println(""+maxLen(new ArrayList<Integer>(Arrays.asList(3, 2, -1))));
    }
}
