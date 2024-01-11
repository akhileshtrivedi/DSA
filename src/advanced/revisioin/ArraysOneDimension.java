package advanced.revisioin;

import java.util.Arrays;

public class ArraysOneDimension {

  private static void fillPrefixSum(int[] arr, int[] prefixSum) {
    prefixSum[0]= arr[0];
    for(int i=1;i<arr.length;i++){
      prefixSum[i]= prefixSum[i-1] + arr[i];
    }
    System.out.println("prefixSum-->"+ Arrays.toString(arr));
  }
  public static void main(String[] args) {
    int arr[] = { 10, 4, 16, 20 };
    int n = arr.length;
    int prefixSum[] = new int[n];

    // Function call
    fillPrefixSum(arr, prefixSum);
    for (int i = 0; i < n; i++)
      System.out.print(prefixSum[i] + " ");
    System.out.println("");
//

     n = 6;
    int[] a = { 3, 6, 2, 8, 9, 2 };
    int[] pf = new int[n + 2];
    pf[0] = 0;
    for (int i = 0; i < n; i++) {
      pf[i + 1] = pf[i] + a[i];
    }
    System.out.println(" here-->"+Arrays.toString(pf));
    int[][] q
        = { { 2, 3 }, { 4, 6 }, { 1, 5 }, { 3, 6 } };
    for (int i = 0; i < q.length; i++) {
      int l = q[i][0];
      int r = q[i][1];

      // Calculating sum from r to l.
      System.out.print(pf[r] - pf[l - 1] + "\n");
    }
  }


  }


