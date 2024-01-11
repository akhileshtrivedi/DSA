package advanced.jan_27;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class MaximumMinimumMagic
{
  private static ArrayList<Integer> solve(ArrayList<Integer> A) {

    int N = A.size();
    Collections.sort(A);
    long maximum = 0;
    long minimum = Long.MAX_VALUE;
    int mod = 1000000007;

    long lowerSum = 0;
    long higherSum = 0;
    int low = 0;
    int high = N - 1;
    while(low < high) {
      lowerSum += A.get(low);
      higherSum += A.get(high);
      low += 1;
      high -= 1;
    }

    maximum = higherSum - lowerSum;

    lowerSum = 0; // 1 3 5 -> 9
    higherSum = 0; // 2 4 6 -> 12
    low = 0;
    high = 1;
    while(high < N) {
      lowerSum += A.get(low);
      higherSum += A.get(high);
      low += 2;
      high += 2;
    }

    minimum = higherSum - lowerSum;

    ArrayList<Integer> arr = new ArrayList<>();
    arr.add((int)(maximum%mod));
    arr.add((int)(minimum%mod));

    return arr;
  }

  // Driver code
  public static void main(String[] args)
  {

   // System.out.println(solve(new ArrayList<Integer>(Arrays.asList(3, 11, -1, 5))));
    System.out.println(solve(new ArrayList<Integer>(Arrays.asList(-98, 54, -52, 15, 23, -97, 12, -64, 52, 85))));

  }
}

