package advanced.april_10;

public class MaxProductSubArray {
  public static long maxSubarrayProduct(int[] arr, int n)
  {
    long ans = Integer.MIN_VALUE;
    long product = 1;
    for (int i = 0; i < n; i++) {
      product *= arr[i];
      ans = Math.max(ans, product);
      if (arr[i] == 0) {
        product = 1;
      }
    }
    product = 1;
    for (int i = n - 1; i >= 0; i--) {
      product *= arr[i];
      ans = Math.max(ans, product);
      if (arr[i] == 0) {
        product = 1;
      }
    }
    return ans;
  }
  public static void main(String[] args)
  {
    int[] arr = {-3, 0, -5, 0 };
    int n = arr.length;
    System.out.println("Maximum Subarray product is " + maxSubarrayProduct(arr, n));
  }
}
