package advanced.jan_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ModSum {
  static int mod = (int)(1e9 + 7);
  private static int solve(ArrayList<Integer> A) {
    int n= A.size();
    int max = Collections.max(A);

    // To store the frequency of each element
    int []cnt=new int[max + 1];

    // Store the frequency of each element
    for (int i = 0; i < n; i++)
      cnt[A.get(i)]++;

    // To store the required answer
    long ans = 0;

    // For all valid pairs
    for (int i = 1; i <= max; i++)
    {
      for (int j = 1; j <= max; j++)
      {

        // Update the count
        ans = ans + cnt[i] *
            cnt[j] * (i % j);
        ans = ans % mod;
      }
    }

    return (int)(ans);
  }
  public static void main(String[] args)
  {
    int a[] = { 1, 2, 3 };
    int n = a.length;

    System.out.println(solve(new ArrayList<>(Arrays.asList(17, 100, 11))));
  }


}
