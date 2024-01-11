package advanced.jan_23;

public class ConsecutiveNumbersSum {
  static int countConsecutive(int N)
  {
    // constraint on values of L gives us the
    // time Complexity as O(N^0.5)
    if(N==1 || N==2|| N==4)
      return 1;
    if(N==3)
      return 2;
    int count = 0;
    for (int L = 1; L * (L + 1) < 2 * N; L++) {
      double a = (double)((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
      if (a - (int)a == 0.0)
        count++;
    }
    return count;
  }

  // Driver code to test above function
  public static void main(String[] args)
  {
    int N = 1;
    System.out.println(countConsecutive(N));
    N = 2;
    System.out.println(countConsecutive(N));
    N = 3;
    System.out.println(countConsecutive(N));
  }
}
