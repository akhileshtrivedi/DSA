package advanced.jan_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FactorialArray {

  private static void
  findSubsets(ArrayList<ArrayList<Integer>> subset, ArrayList<Integer> nums,
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

  private static boolean isCheck(ArrayList<Integer> num, ArrayList<Integer> primeList) {
    int cnt = 0;
    int preFact = 1;
    int currentFact = 1;

    for (int j = 0; j < num.size(); ++j) {
      for (int i = 0; i < primeList.size(); ++i) {
        if (num.get(j) % primeList.get(i) == 0) {
          if (j == 0) {
            preFact = preFact * primeList.get(i);
          }else{
            currentFact = currentFact * primeList.get(i);
          }
        }
      }
      if (!(preFact == currentFact) && j > 0) {
        return false;
      }
    }
    return true;
  }

  private static boolean isPrime(int n) {
    //since 0 and 1 is not prime return false.
    if (n == 1 || n == 0) {
      return false;
    }

    //Run a loop from 2 to square root of n
    for (int i = 2; i * i <= n; i++) {
      // if the number is divisible by i, then n is not a prime number.
      if (n % i == 0) {
        return false;
      }
    }
    //otherwise, n is prime number.
    return true;
  }

  private static int subsets(ArrayList<Integer> inputArrList) {
    ArrayList<ArrayList<Integer>> subset = new ArrayList<>();
    ArrayList<Integer> primeList = new ArrayList<Integer>();
    int count = 0;
    for (int i = 1; i <= 100; i++) {
      if (isPrime(i)) {
        primeList.add(i);
      }
    }
    findSubsets(subset, inputArrList, new ArrayList<>(), 0);

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
    System.out.println(""+subset);
    for (int i = 0; i < subset.size(); i++) {
      if (isCheck(subset.get(i), primeList)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    // System.out.println("I am here" + subsets(new ArrayList<Integer>(Arrays.asList(2, 3, 4))));
    System.out.println("I am here" + subsets(new ArrayList<Integer>(Arrays.asList(5, 2, 3, 4, 5, 6))));
    int[] arr = {1, 2, 3};
    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    // System.out.println("---->" + printSubsequences(arr, 0, path, result));
  }

}
