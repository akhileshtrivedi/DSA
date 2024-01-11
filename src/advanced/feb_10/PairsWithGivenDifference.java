package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PairsWithGivenDifference {

  private static int solve(ArrayList<Integer> A, int B) {
    Collections.sort(A);
    int i = 1, j = 0, count = 0;
//1, 5, 3, 4, 2
    while (i < A.size()) {
      System.out.println(i + "<-- i here--> j " + j);
      System.out.println(A.get(i) + "<-- --> j " + A.get(j));
      //   System.out.println(A.size()+"<-- size  B-->"+B);
      if (A.get(i) - A.get(j) == B) {
        count++;
        System.out.println("count--->" + count);
        return count;
      } else if (A.get(i) - A.get(j) < B) {
        return i++;
      } else {
        return j++;
      }
    }

    return count;
  }

  static int countPairsWithDiffK(ArrayList<Integer> A,
      int B) {
    Set<Integer> set= new HashSet<>();

    int n = A.size();
    Collections.sort(A);

    int l = 0;
    int r = 1;
    if(A.get(r) - A.get(l)>0&&B==0){
      return set.size();
    }
    while (r < n) {
      if (A.get(r) - A.get(l) == B) {
        set.add(A.get(l));
    //    System.out.println(A.get(l)+"-- "+A.get(r));
        l++;
        r++;
      } else if (A.get(r) - A.get(l) >B) {
        l++;
      } else {
        r++;
      }
    }
    return set.size();
  }

  public static void main(String[] args) {

     System.out.println(""+countPairsWithDiffK(new ArrayList<>(Arrays.asList(1, 1,1,1,1)), 0));
     System.out.println(""+countPairsWithDiffK(new ArrayList<>(Arrays.asList(1, 2)), 0));
    // System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 5, 3, 4, 2)), 3));
   // System.out.println("" + countPairsWithDiffK(new ArrayList<>(Arrays.asList(1, 5, 3, 4, 2)), 3));
   // System.out.println("" + countPairsWithDiffK(new ArrayList<>(Arrays.asList(8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3)), 3));
  }
//8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3
}
