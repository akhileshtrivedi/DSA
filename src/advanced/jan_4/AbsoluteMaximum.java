package advanced.jan_4;

import java.util.ArrayList;
import java.util.Arrays;

public class AbsoluteMaximum {

  private static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C,
      ArrayList<Integer> D) {
    int n = A.size();
    int[] e = new int[n + 5];
    int ans = 0;

    for (int p = 0; p < 32; ++p) {

      for (int i = 0; i < n; ++i) {
        e[i] = 0;
      }

      int mxx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;

      for (int i = 0; i < n; ++i) {

        for (int k = 0; k < 5; ++k) {
          int temp;

          if (k == 0) {
            temp = A.get(i);
          } else if (k == 1) {
            temp = B.get(i);
          } else if (k == 2) {
            temp = C.get(i);
          } else if (k == 3) {
            temp = D.get(i);
          } else {
            temp = i;
          }
          System.out.println(" if condition here" + (p & (1 << k)));
          if ((p & (1 << k)) > 0) {
            e[i] += temp;
          } else {
            e[i] -= temp;
          }
        }
        mxx = Math.max(mxx, e[i]);
        mn = Math.min(mn, e[i]);
      }
      ans = Math.max(ans, mxx - mn);
    }

    return ans;
  }
  /*
  public static int maxArr(ArrayList<Integer> A) {
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    for (int i = 0; i < A.size(); i++) {
      max1 = Math.max(max1, A.get(i) + i);
      min1 = Math.min(min1, A.get(i) + i);
      max2 = Math.max(max2, A.get(i) - i);
      min2 = Math.min(min2, A.get(i) - i);
    }
    return Math.max(max1 - min1, max2 - min2);
  }


  private static int calculateDiff(int i, int j,
      int[] array, int[] array2, int[] array3, int[] array4) {
    return Math.abs(array[i] - array[j]) + Math.abs(array2[i] - array2[j]) + Math.abs(
        array3[i] - array3[j]) +
        Math.abs(array4[i] - array4[j]) + Math.abs(i - j);
  }

  private static int maxDistance(int[] array, int[] array2, int[] array3, int[] array4) {
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j < array.length; j++) {
        result = Math.max(result, calculateDiff(i, j, array, array2, array3, array4));
      }
    }
    return result;
  }*/

  public static void main(String[] args) {
    //  int[] array = { -70, -64, -6, -56, 64, 61, -57, 16, 48, -98 };
/*
    int[] array = {1, 2, 3, 4};
    int[] array2 = {-1, 4, 5, 6};
    int[] array3 = {-10, 5, 3, -8};
    int[] array4 = {-1, -9, -6, -10};
    System.out.println(maxDistance(array, array2, array3, array4));
*/

//    ArrayList al = new ArrayList<>();
//    al.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
//    al.add(new ArrayList<Integer>(Arrays.asList(-1, 4, 5, 6)));
//    al.add(new ArrayList<Integer>(Arrays.asList(-10, 5, 3, -8)));
//    al.add(new ArrayList<Integer>(Arrays.asList(-1, -9, -6, -10)));
    System.out.println("solve--->" + solve(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)),
        new ArrayList<Integer>(Arrays.asList(-1, 4, 5, 6))
        , new ArrayList<Integer>(Arrays.asList(-10, 5, 3, -8)),
        new ArrayList<Integer>(Arrays.asList(-1, -9, -6, -10))));

    // for(int i=0;i<al.size();i++){
    //  System.out.println("maxArr-->"+maxArr((ArrayList<Integer>)al.get(i)));
    // };
  }

}
