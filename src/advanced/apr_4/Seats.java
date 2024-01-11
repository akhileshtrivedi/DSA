package advanced.apr_4;

import java.util.*;
class Seats{

  static int MOD = (int)1e9 + 7;

  static int minJumps(String A)
  {
    Vector<Integer> position = new Vector<>();
    int count = 0;
    int len = A.length();
    for (int i = 0; i < len; i++)
    {
      if (A.charAt(i) == 'x')
      {
        position.add(i - count);
        count++;
      }
    }
    if (count == len ||
        count == 0)
      return 0;
    int med_index = (count - 1) / 2;
    int med_val = position.get(med_index);
    int ans = 0;
    for (int i = 0;
        i < position.size(); i++)
    {
      ans = (ans % MOD +
          Math.abs(position.get(i) -
              med_val) % MOD) % MOD;
    }
    return ans % MOD;
  }

  // Driver Code
  public static void main(String[] args)
  {

   // String S = "....x..xx...x..";
 String    S = "....xxx";
// Function Call
    System.out.print(minJumps(S));
  }
}

// This code is contributed by gauravrajput1
