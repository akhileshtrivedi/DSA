package advanced.jan_27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MergeTwoSortedArrays {

  static void mergeArrays(int a[], int b[], int n, int m) {

    Map<Integer, Boolean> mp = new TreeMap<Integer, Boolean>();
    for (int i = 0; i < n; i++) {
      mp.put(a[i], true);
    }
    for (int i = 0; i < m; i++) {
      mp.put(b[i], true);
    }
    for (Map.Entry<Integer, Boolean> me : mp.entrySet()) {
      System.out.print(me.getKey() + " ");
    }
  }
  public static ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
    ArrayList<Integer> result = new ArrayList<>();

    Map<Integer, Boolean> mp = new TreeMap<Integer, Boolean>();
    for (int i = 0; i < A.size(); i++) {
      mp.put(A.get(i), true);
    }
    for (int i = 0; i < B.size(); i++) {
      mp.put(B.get(i), true);
    }
    System.out.println(""+mp);
    for (Map.Entry<Integer, Boolean> me : mp.entrySet()) {
      result.add(me.getKey());
    }
    return result;
  }
 static ArrayList<Integer> merge(final List<Integer> A, final List<Integer> B) {
   int fooLength = A.size();
   int barLength = B.size();

   ArrayList<Integer> merged = new ArrayList<Integer>();

   int fooPosition, barPosition, mergedPosition;
   fooPosition = barPosition = mergedPosition = 0;

   while(fooPosition < fooLength && barPosition < barLength) {
     if (A.get(fooPosition) < B.get(barPosition)) {
       merged.add(A.get(fooPosition++));
      // merged[mergedPosition++] = A[fooPosition++];
     } else {
       merged.add(B.get(barPosition++));
       //merged[mergedPosition++] = B[barPosition++];
     }
   }

   while (fooPosition < fooLength) {
     merged.add(A.get(fooPosition++));
   //  merged[mergedPosition++] = A[fooPosition++];
   }

   while (barPosition < barLength) {
     merged.add(B.get(barPosition++));
    // merged[mergedPosition++] = B[barPosition++];
   }

   return merged;
  }
  // Driver Code
  public static void main(String[] args) {
    int a[] = { -4, 3 }, b[] = {-2, -2};
    int size = a.length;
    int size1 = b.length;
    // mergeArrays(a, b, size, size1);
    // Function call
  //  System.out.println("mergeArrays-->"+Arrays.toString(merge(a, b)));
    //  System.out.println("mergeArrays-->"+solve(new ArrayList<Integer>(Arrays.asList(-4,3)), new ArrayList<Integer>(Arrays.asList(-2, -2))));
      System.out.println("mergeArrays-->"+merge(new ArrayList<Integer>(Arrays.asList(-4,3)), new ArrayList<Integer>(Arrays.asList(-2, -2))));
  }
}

