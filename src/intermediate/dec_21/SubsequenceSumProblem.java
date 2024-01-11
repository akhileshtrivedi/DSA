package intermediate.dec_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsequenceSumProblem {
  public static int MOD = 1000000007;

  private static void findSubsets(ArrayList<ArrayList<Integer>> subset, ArrayList<Integer> nums,
      ArrayList<Integer> output, int index) {
    if (index == nums.size()) {
      Collections.sort(output);
      if (!output.isEmpty()) {
        subset.add(output);
      }
      return;
    }

    findSubsets(subset, nums, new ArrayList<>(output), index + 1);

    output.add(nums.get(index));

    findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    output.remove(output.size() - 1);
  }

  private static boolean checkSum(ArrayList<Integer> A, int total) {
    long sum = 0;
    for (int i = 0; i < A.size(); i++) {
      sum = (sum + A.get(i))%MOD;
    }
    return (int)sum == total;
  }

  private static int subsets(ArrayList<Integer> A, int B) {
    ArrayList<ArrayList<Integer>> subset = new ArrayList<>();
    findSubsets(subset, A, new ArrayList<>(), 0);
    Collections.sort(subset, (o1, o2) -> {
      int n = Math.min(o1.size(), o2.size());
      for (int i = 0; i < n; i++) {
        if (o1.get(i) == o2.get(i)) {
          continue;
        } else {

          return o1.get(i) - o2.get(i);
        }
      }
      return o1.size() - o2.size();
    });
  //  System.out.println("" + subset);
    for (int i = 0; i < subset.size(); i++) {
      if (checkSum(subset.get(i), B)) {
        return 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {

    System.out.println("I am here" + subsets(new ArrayList<Integer>(
        Arrays.asList(1, 20, 13, 4, 5)), 18));
    System.out.println("I am here" + subsets(new ArrayList<Integer>(
        Arrays.asList(65789, 40198, 14476, 98338, 98135)), 64344874));
  }

}
