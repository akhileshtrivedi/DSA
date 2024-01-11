package advanced.jan_18;

import java.util.ArrayList;
import java.util.Arrays;

public class DeleteOne {

  static int gcd(int a, int b)
  {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }


  static int MaxGCD(int a[], int n)
  {

    int Prefix[] = new int[n + 2];
    int Suffix[] = new int[n + 2] ;

    Prefix[1] = a[0];
    for (int i = 2; i <= n; i += 1)
    {
      Prefix[i] = gcd(Prefix[i - 1], a[i - 1]);
    }

    Suffix[n] = a[n - 1];

    for (int i = n - 1; i >= 1; i -= 1)
    {
      Suffix[i] = gcd(Suffix[i + 1], a[i - 1]);
    }

    int ans = Math.max(Suffix[2], Prefix[n - 1]);

    for (int i = 2; i < n; i += 1)
    {
      ans = Math.max(ans, gcd(Prefix[i - 1], Suffix[i + 1]));
    }

    return ans;
  }
  static int solve(ArrayList<Integer> A)
  {
    int n = A.size();
    int Prefix[] = new int[n + 2];
    int Suffix[] = new int[n + 2] ;

    Prefix[1] = A.get(0);
    for (int i = 2; i <= n; i += 1)
    {
      Prefix[i] = gcd(Prefix[i - 1], A.get(i - 1));
    }

    Suffix[n] = A.get(n - 1);

    for (int i = n - 1; i >= 1; i -= 1)
    {
      Suffix[i] = gcd(Suffix[i + 1], A.get(i - 1));
    }

    int ans = Math.max(Suffix[2], Prefix[n - 1]);

    for (int i = 2; i < n; i += 1)
    {
      ans = Math.max(ans, gcd(Prefix[i - 1], Suffix[i + 1]));
    }

    return ans;
  }
  public static void main(String[] args)
  {

    int a[] = { 5, 15, 30};
    int n = a.length;

   // System.out.println(MaxGCD(a, n));
    System.out.println(solve(new ArrayList<>(Arrays.asList(12, 15, 18))));
    System.out.println(solve(new ArrayList<>(Arrays.asList(5, 15, 30))));
  }
}

