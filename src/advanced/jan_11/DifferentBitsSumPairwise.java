package advanced.jan_11;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class DifferentBitsSumPairwise {

  static int cntBits(ArrayList<Integer> A){
    int ans = 0;
    int n=A.size();
    for (int i = 0; i < 32; i++) {
      int count = 0;
      for (int j = 0; j < n; j++)
        if ((A.get(j) & (1 << i)) != 0)
          count++;
      ans += (count * (n - count) * 2);
    }
    return ans;
  }


  public static void main (String[] args) {
   // int[] arr = {5,10};
    int[] arr = {1,3,5};
    int[] arr2 = {2,3};
    int ans = cntBits(new ArrayList<>(Arrays.asList(1,3,5)));
    int ans2 = cntBits(new ArrayList<>(Arrays.asList(2,3)));
    System.out.println(ans);

    System.out.println(ans2);
  }
}
