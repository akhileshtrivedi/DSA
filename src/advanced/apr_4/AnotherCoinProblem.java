package advanced.apr_4;

// Java program to find minimum
// number of denominations
import java.util.Vector;

class AnotherCoinProblem
{

  // All denominations of Indian Currency
  static int deno[] = {1, 5, 25, 125, 625, 3125, 15625};
  static int n = deno.length;

  static int findMin(int V)
  {
    Vector<Integer> ans = new Vector<>();
    for (int i = n - 1; i >= 0; i--)
    {
      while (V >= deno[i])
      {
        V -= deno[i];
        ans.add(deno[i]);
      }
    }
    return ans.size();
  }

  // Driver code
  public static void main(String[] args)
  {
    int n = 9;
    System.out.print(
        "Following is minimal number "
            +"of change for " + n + ":--> "+findMin(n));

  }
}

// This code is contributed by 29AjayKumar
