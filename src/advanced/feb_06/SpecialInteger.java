package advanced.feb_06;


import java.util.Arrays;

class SpecialInteger
{
  public static int MOD = 1000000007;
  // Function to find the length of the smallest subarray whose sum
  // of elements is greater than the given number
  public static int findSmallestSubarrayLen(int[] A, int k)
  {
    int windowSum = 0;
    int len = Integer.MAX_VALUE;
    int left = 0;
    for (int right = 0; right < A.length; right++)
    {
      windowSum += A[right];
      while (windowSum > k && left <= right)
      {
        len = Integer.min(len, right - left + 1);
        windowSum -= A[left];
        left++;
      }
    }
    if (len == Integer.MAX_VALUE) {
      return 0;
    }

    return len-1;
  }
  static int maxSize(int arr[], int B)
  {
    int n = arr.length;
    // Initialize prefix sum array as 0.
    long prefixsum[] = new long[n + 1];
    Arrays.fill(prefixsum, 0);
    for (int i = 0; i < n; i++)
      prefixsum[i + 1] = prefixsum[i] + arr[i];

    return bsearch(prefixsum, B);
  }
  static int bsearch(long prefixsum[], int k)
  {
    int n = prefixsum.length;
    long ans = 0;
    int left = 1, right = n;

    while (left <= right)
    {
      int mid = (left + right) / 2;
      int i;
      for (i = mid; i <= n; i++)
      {
        if (prefixsum[i] - prefixsum[i - mid] > k)
          break;
      }
      if (i == n + 1)
      {
        left = mid + 1;
        ans = mid;
      }
      else
        right = mid - 1;
    }
    ans=ans%MOD;
    return (int)ans;
  }
  public static void main(String[] args)
  {
    // an array of positive numbers
    int[] AA = {5, 17, 100, 11};
    int kk = 130;
    int[] A = {1, 2, 3, 4, 5, 100};
    int k = 10;
    System.out.println(maxSize(A, k));
    System.out.println(maxSize(AA, kk));
    // find the length of the smallest subarray
  /*  int len = findSmallestSubarrayLen(AA, kk);

    if (len != Integer.MAX_VALUE) {
      System.out.print("The smallest subarray length is " + len);
    }
    else {
      System.out.print("No subarray exists");
    }*/
  }
}