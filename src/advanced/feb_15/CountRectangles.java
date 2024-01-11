package advanced.feb_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class CountRectangles{

  static int[] findSubarrays(int[] a)
  {
    int n = a.length;
    int[] freq = new int[n + 1];
    int count = 0;
    for (int i = 0; i < n; i++)
    {
      if (a[i] == 0)
      {
        if (count == 0)
          continue;

        else
        {
          int value = count;
          for (int j = 1; j <= count; j++)
          {

            freq[j] += value;
            value--;
          }
          count = 0;
        }
      }
      else
        count++;
    }

    if (count > 0)
    {
      int value = count;
      for (int j = 1; j <= count; j++)
      {
        freq[j] += value;
        value--;
      }
    }
    return freq;
  }

  static void countRectangles(int[] a, int[] b, int K)
  {
    int n = a.length;
    int m = b.length;

    int[] subA = findSubarrays(a);
    int[] subB = findSubarrays(b);
    int total = 0;

    for (int i = 1; i < subA.length; i++)
    {
      if (K % i == 0 && (K / i) <= m)
      {
        total = total + subA[i] * subB[K / i];
      }
    }
    System.out.print(total);
  }
  public int solve(int[] a, int[] b) {
    int n = a.length;
    HashMap<Integer, HashSet> mpx = new HashMap<>();
    HashSet h;
    for (int i = 0; i < n; i++) {
      if (mpx.containsKey(a[i]))
        h = mpx.get(a[i]);
      else
        h = new HashSet<>();
      h.add(b[i]);
      mpx.put(a[i], h);
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (a[i] == a[j] || b[i] == b[j])
          continue;
        if (mpx.get(a[i]).contains(b[j]) && mpx.get(a[j]).contains(b[i]))
          ans++;
      }
    }
    return ans >> 1;
  }
  private static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    int n = A.size();
    System.out.println("A size "+A.size());
    System.out.println("B size "+B.size());
    HashMap<Integer, HashSet> mpx = new HashMap<>();
    HashSet h;
    for (int i = 0; i < n; i++) {
      if (mpx.containsKey(A.get(i)))
        h = mpx.get(A.get(i));
      else
        h = new HashSet<>();
      h.add(B.get(i));
      mpx.put(A.get(i), h);
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (A.get(i) == A.get(j) || B.get(i) == B.get(j))
          continue;
        if (mpx.get(A.get(i)).contains(B.get(j)) && mpx.get(A.get(j)).contains(B.get(i)))
          ans++;
      }
    }
    return ans >> 1;
  }

  public static void main(String[] args)
  {
    int[] a = {1, 1, 2, 2};
    int[] b = {1, 2, 1, 2};
    int[] aa = {1, 1, 2, 2, 3, 3};
    int[] bb = {1, 2, 1, 2, 1, 2};
   // int K = 2;
   // countRectangles(a, b, K);
  //  System.out.println(solve(a,b));
   // System.out.println(solve(aa,bb));
//    System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2)),
//        new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2))));
//    System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2, 3, 3)),
//        new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2, 1, 2))));
    System.out.println(solve(new ArrayList<Integer>(Arrays.asList(1302, 589, 651, 279, 1054, 1550, 310, 496, 1519, 992, 1302, 279, 1488, 1488, 434, 1178, 1054, 1054, 930, 930, 682, 341, 775, 62, 434, 899, 992, 1395, 1457, 1085, 1116, 496, 496, 155, 1116, 806, 310, 372, 1116, 496, 744, 93, 186, 372, 1178, 372, 1519, 1271, 0, 124, 31, 620, 93, 155, 465, 1023, 93, 217, 806, 217, 961, 558, 155, 1457, 1457, 124, 403, 992, 1457, 341, 1457, 248, 403 )),
        new ArrayList<Integer>(Arrays.asList(1302, 248, 589, 93, 0, 961, 310, 868, 1209, 372, 620, 1178, 1178, 0, 1426, 1519, 310, 899, 403, 620, 1426, 527, 806, 1023, 1085, 1271, 527, 1085, 744, 310, 1240, 527, 341, 775, 62, 651, 806, 31, 1302, 1550, 1209, 713, 527, 1116, 0, 589, 651, 961, 403, 1023, 651, 465, 1488, 248, 961, 93, 589, 124, 93, 682, 1426, 992, 682, 1054, 217, 1426, 1085, 217, 1085, 1488, 1457, 620, 1302 ))));
  }
}

// This code is contributed by shikhasingrajput
