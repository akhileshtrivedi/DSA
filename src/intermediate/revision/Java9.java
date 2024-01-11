package intermediate.revision;

import java.util.ArrayList;
import java.util.Arrays;

public class Java9 {

  private static ArrayList<Integer> getSubarrayByRange(ArrayList<Integer> A, int B, int C) {
    ArrayList<Integer> al = new ArrayList<>();
    for (int i = B; i <= C; i++) {
      al.add(A.get(i));
    }
    return al;
  }

  private static int maxSubarray(int A, int B, ArrayList<Integer> C) {
    int curr_sum = C.get(0), max_sum = 0, start = 0;
    for (int i = 1; i < A; i++) {
      if (curr_sum <= B) {
        max_sum = Math.max(max_sum, curr_sum);
      }
      while (curr_sum + C.get(i) > B && start < i) {
        curr_sum -= C.get(start);
        start++;
      }
      curr_sum += C.get(i);
    }
    if (curr_sum <= B) {
      max_sum = Math.max(max_sum, curr_sum);
    }

    return max_sum;
  }

  private static Long subarraySum(ArrayList<Integer> A) {
    long totalSum = 0;
    int len = A.size();
    for (int i = 0; i < len; i++) {
      totalSum += (long) (A.get(i) * (long) (i + 1) * (long) (len - i));
    }
    return totalSum;
  }

  private static ArrayList<ArrayList<Integer>> getAllSubarray(ArrayList<Integer> A) {
    ArrayList<ArrayList<Integer>> allSubArrays = new ArrayList<ArrayList<Integer>>();

    int arrSize = A.size();
    //start point
    for (int startPoint = 0; startPoint < arrSize; startPoint++) {
      //group sizes
      for (int grps = startPoint; grps < arrSize; grps++) {
        ArrayList<Integer> subArrays = new ArrayList<>();
        for (int j = startPoint; j <= grps; j++) {
          subArrays.add(A.get(j));
        }
        allSubArrays.add(subArrays);
      }
    }
    return allSubArrays;
  }

  // Homework
  private static ArrayList<Integer> getAlternateSubarray(ArrayList<Integer> A, int B) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    if (B == 0) {
      for (int i = 0; i < A.size(); i++) {
        ans.add(i);
      }
      return ans;
    }
    int i = 0;

    for (int j = 0; j < A.size(); j++) {
      if (i == j) {
        continue;
      } else {
        if (A.get(j) == A.get(j - 1)) {
          i = j;
        } else {
          if ((j - i + 1) == (2 * B + 1)) {
            int x = (i + j) / 2;
            ans.add(x);
            i++;
          }
        }
      }
    }
    return ans;
  }
  private static  int getGoodSubarray(ArrayList<Integer> A, int B) {
    int ans=0;
    int n =A.size();
    for(int i=0; i<n; i++) { // for all i
      int sum=0;
      int j=i;

      while(j<n){
        sum+=A.get(j++);
        if(sum<B && (j-i)%2==0){
          ans++;
        } else if(sum>B && (j-i)%2==1){
          ans++;
        }
      }

    }
    return ans;
  }
  private static int getCountSubarray(int[] arr, int k) {
    int n = arr.length;
    int start = 0, end = 0;
    int count = 0, sum = arr[0];

    while (start < n && end < n) {

      if (sum < k) {
        end++;

        if (end >= start)
          count += end - start;


        if (end < n)
          sum += arr[end];
      } else {
        sum -= arr[start];
        start++;
      }
    }

    return count;
  }
  public static void main(String[] args) {
    // System.out.println("Subarray-->"+getSubarrayByRange(new ArrayList<Integer>(Arrays.asList(4, 3, 2, 6)),1,3));
    // System.out.println("Subarray-->"+subarraySum(new ArrayList<Integer>(Arrays.asList(4, 3, 2, 6))));
    // System.out.println("Subarray-->"+subarraySum(new ArrayList<Integer>(Arrays.asList(4, 3))));
    //System.out.println(
  //      "Subarray-->" + getAlternateSubarray(new ArrayList<Integer>(Arrays.asList(4, 3, 2, 6)),2));
    System.out.println(
        "Subarray-->" + getGoodSubarray(new ArrayList<Integer>(Arrays.asList(4, 3, 2, 6)),2));
  }
}

