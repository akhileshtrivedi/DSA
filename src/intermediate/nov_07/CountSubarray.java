package intermediate.nov_07;

public class CountSubarray {
    static int countSubarray(int arr[], int k)
    {
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
    public static int solve(int[] a, int B) {
        int ans = 0;
        int n = a.length;
        int r = 0;
        for (int i = 0; i < n; i++) { // for all i
            int sum = 0;
            int j = i;
            while (j < n && sum + a[j] < B)
                sum += a[j++];
            ans += (j - i);
        }
        return ans;
    }
    // Driver Code
    public static void main(String[] args)
    {
        int[] A={1, 2, 3, 4, 5};
        int B = 4;
        int array[] = { 1, 11, 2, 3, 15 };
        int k = 10;
      //  int count = countSubarray(array, k);
        int count = solve(A, B);
        System.out.println(count);
    }
}
