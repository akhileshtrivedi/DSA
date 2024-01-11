package sat;

import java.util.HashSet;
import java.util.Set;

public class SubArray {
    public  Boolean zeroSumSubArray(int arr[])
    {
        Set<Integer> hs = new HashSet<Integer>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0 || sum == 0 || hs.contains(sum))
                return true;
            hs.add(sum);
        }
        return false;
    }
    public void subArraySum(int arr[], int n, int sum)
    {
        // Pick a starting point
        for (int i = 0; i < n; i++) {
            int currentSum = arr[i];

            if (currentSum == sum) {
                System.out.println("Sum found at indexe "
                        + i);
                return;
            }
            else {
                for (int j = i + 1; j < n; j++) {
                    currentSum += arr[j];

                    if (currentSum == sum) {
                        System.out.println(
                                "Sum found between indexes " + i
                                        + " and " + j);
                        return;
                    }
                }
            }
        }
        System.out.println("No subarray found");
        return;
    }

    public static void main(String[] args)
    {
        SubArray arraysum = new SubArray();
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int sum = 23;
       // int arr[] = {1,2,3,4,5 };
        int array[] = {1,2,3,4,-10 };
        arraysum.subArraySum(arr, n, sum);
        arraysum.subArraySum(array, 5, 0);
        System.out.println("here--->"+ arraysum.zeroSumSubArray(array));

    }
}


