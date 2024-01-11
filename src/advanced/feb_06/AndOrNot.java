package advanced.feb_06;

// Java program for the above approach

import java.util.ArrayList;
import java.util.Arrays;

class AndOrNot {
  //    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
  static ArrayList<Integer> findMostFrequent(ArrayList<Integer> A, int B) {
    ArrayList<Integer> ans= new ArrayList<>();
    int[] arr = A.stream().mapToInt(i->i).toArray();
    int start = 0, end = 0;
    int N = arr.length;
    Arrays.sort(arr);
    int mostFreq = Integer.MIN_VALUE, sum = 0;
    for (end = 0; end < N; end++) {
      sum = sum + arr[end];
      while (sum + B < arr[end] * (end - start + 1)) {
        sum = sum - arr[start];
        start++;
      }
      mostFreq = Math.max(mostFreq,
          end - start + 1);
    }
    int reqSum = arr[N - 1] * N - sum;
    if (mostFreq == N && reqSum < B) {
      B = B - reqSum;
      if (B % N == 0) {
      } else {
      }
    }
    ans.add(mostFreq);
    ans.add((sum+start) / mostFreq);
    return ans;
  }


  static int[] findMostFrequent2(int arr[], int K) {
    int C[] = new int[2];
    int start = 0, end = 0;
    int N = arr.length;
    // Sort the given array
    Arrays.sort(arr);

    // Stores the maximum frequency
    // and the sum of sliding window
    int mostFreq = Integer.MIN_VALUE, sum = 0;

    // Traverse the array arr[]
    for (end = 0; end < N; end++) {

      // Add the current element
      // to the window
      sum = sum + arr[end];

      // Decreasing the window size
      while (sum + K < arr[end] * (end - start + 1)) {

        // Update the value of sum
        // by subtracting arr[start]
        sum = sum - arr[start];

        // Increment the value
        // of the start
        start++;
      }

      // Update maximum window size
      mostFreq = Math.max(mostFreq,
          end - start + 1);
    }

    // Stores the required sum to
    // make all elements of arr[] equal
    int reqSum = arr[N - 1] * N - sum;

    // If result from at most K increments
    // is N and K is greater than reqSum
    if (mostFreq == N && reqSum < K) {

      // Decrement the value of K
      // by reqSum
      K = K - reqSum;

      // If K is multiple of N then
      // increment K/N times to
      // every element
      if (K % N == 0) {
        //  C[0] = mostFreq;
        //  C[1] = reqSum / mostFreq;
        System.out.println(sum + "if-->" + N);
        System.out.println(reqSum + "if-->" + N);

      }

      // Otherwise first make every
      // element equal then increment
      // remaining K to one element
      else {
        // C[0] = mostFreq;
        // C[1] = reqSum / mostFreq;
        System.out.println(reqSum + "else-->" + (N - 1));
      }
//9354471228
    }
    C[0] = mostFreq;
    C[1] = sum / mostFreq;
    // Print the answer
    System.out.println(reqSum + "mostFreq here-->" + mostFreq);
    return C;
  }

  private static ArrayList<Integer> solve(ArrayList<Integer> AA, int B) {
    ArrayList<Integer> ans= new ArrayList<>();
    int[] A = AA.stream().mapToInt(i->i).toArray();

    long prefix[] = new long[A.length + 1];
    Arrays.sort(A);
    int n = A.length;
    // Make prefix array
    for (int i = 0; i < n; i++) {
      prefix[i + 1] += A[i] + prefix[i];
    }

    ans.add(-1);
    ans.add(-1);
    for (int i = 0; i < n; i++) {
      int lo = 1, hi = i + 1;
      int mx = 0;
      // Binary search to find the value of cnt for each i
      while (lo <= hi) {
        int cnt = (lo + hi) / 2;
        if ((long) A[i] * cnt - (prefix[i + 1] - prefix[i - cnt + 1]) <= B) {
          mx = cnt;
          lo = cnt + 1;
        } else {
          hi = cnt - 1;
        }
      }
      // Update ans
      if (ans.get(0) < mx) {
        ans.set(0, mx) ;
        ans.set(1, A[i]) ;
      }
    }
    return ans;
  }
  // Driver Code
  public static void main(String[] args) {
    // int arr[] = { 4, 3, 4 };
    // int K = 5;
    int arr[] = {3, 1, 2, 2, 1};
    int arr2[] = {5, 5, 5};
    int K = 3;
    int KK = 3;
    System.out.println("int--->"+solve(new ArrayList<>(Arrays.asList(3, 1, 2, 2, 1)), 5));
    System.out.println("int--->"+solve(new ArrayList<>(Arrays.asList(5, 5, 5)), 3));

    ;
    // findMostFrequent(arr2, KK);
  }
}

// This code is contributed by target_2.
