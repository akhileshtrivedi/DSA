package advanced.feb_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSequence {

  private static int longestConsecutive( List<Integer> A) {
    Collections.sort(A);
    HashMap hm= new HashMap<>();

    int count=0;
    int startVal = A.get(0);
    for (int i = 0; i < A.size(); i++) {

      if (hm.containsKey(A.get(i))) {
         // hm.put(A.get(i), hm.get(A.get(i))+1);


        count++;
      } else {
        hm.put(A.get(i), 1);
      }
    }
    return count;
  }
  static int findLongestConseqSubseq(List<Integer> A)
  {
    int n = A.size();
    int ans = 0;
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < n; ++i)
      set.add(A.get(i));

    for (int i = 0; i < n; ++i) {

      if (!set.contains(A.get(i) - 1)) {
        int j = A.get(i);
        while (set.contains(j)){
          set.remove(Integer.valueOf(j));
          j++;
        }

        if (ans < j - A.get(i))
          ans = j - A.get(i);
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    System.out.println(findLongestConseqSubseq(new ArrayList<>(Arrays.asList(100, 4, 200, 1, 3, 2))));
    System.out.println(findLongestConseqSubseq(new ArrayList<>(Arrays.asList(2, 1))));

   // System.out.println(longestConsecutive(new ArrayList<>(Arrays.asList(100, 4, 200, 1, 3, 2))));

  }

}
