package advanced.jan_18;

import java.util.ArrayList;
import java.util.Arrays;

// Java implementation of the above approach
class Pubg
{

  static int minHealth(int health[])
  {
    int n = health.length;
    // Find the GCD of the array elements
    int gcd = 0;
    for (int i = 0; i < n; i++)
    {
      gcd = getGCD(gcd, health[i]);
    }
    return gcd;
  }

  static int getGCD(int a, int b)
  {
    return b == 0 ? a : getGCD(b, a % b);
  }
  private static int solve(ArrayList<Integer> A) {
    int n = A.size();

    int gcd = 0;
    for (int i = 0; i < n; i++)
    {
      gcd = getGCD(gcd, A.get(i));
    }
    return gcd;
  }
  // Driver code
  public static void main(String []args)
  {
    int health[] = {6, 4};
    int health2[] = {2, 3, 4 };


   // System.out.println(minHealth(health));
    //System.out.println(minHealth(health2));
    System.out.println(solve(new ArrayList<>(Arrays.asList(6,4))));
    System.out.println(solve(new ArrayList<>(Arrays.asList(2,3,4))));

  }
}

// This code is contributed by PrinciRaj1992
