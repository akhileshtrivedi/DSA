package advanced.jan_16;

import java.util.ArrayList;
import java.util.*;

class PairSumDivisibleByM {
  public static int countKdivPairs(int A[],int K)
  {
    int n=A.length;
    int freq[] = new int[K];

    for (int i = 0; i < n; i++)
      ++freq[A[i] % K];

    int sum = freq[0] * (freq[0] - 1) / 2;

    for (int i = 1; i <= K / 2 && i != (K - i); i++)
      sum += freq[i] * freq[K - i];

    if (K % 2 == 0)
      sum += (freq[K / 2] * (freq[K / 2] - 1) / 2);
    return sum;
  }
  private static int solve(ArrayList<Integer> Al, int B) {
    int MOD = 1000000007;
    Integer[] A = new Integer[Al.size()];
    A = Al.toArray(A);
    int n=Al.size();
    int freq[] = new int[B];
    long sum;
    for (int i = 0; i < n; i++)
      ++freq[A[i] % B];

     sum = freq[0] * (freq[0] - 1) / 2;

    for (int i = 1; i <= B / 2 && i != (B - i); i++)
      sum += freq[i] * freq[B - i];

    if (B % 2 == 0)
      sum += (freq[B / 2] * (freq[B / 2] - 1) / 2);
    return (int)sum%MOD;
  }
  public static void main(String[] args)
  {
    int A[] = { 2, 2, 1, 7, 5, 3 };
    int n = 6;
    int K = 4;
  //  System.out.print(countKdivPairs(A,K));
    System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 2));
  }
}
