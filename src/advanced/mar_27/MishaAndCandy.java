package advanced.mar_27;

// Java program for the above approach
import java.io.*;

class MishaAndCandy{

  // Function to count the minimum number
// of candies that is to be distributed
  static int countCandies(int arr[], int n)
  {

    // Stores total count of candies
    int sum = 0;

    // Stores the amount of candies
    // allocated to a student
    int[] ans = new int[n];

    // If the value of N is 1
    if (n == 1)
    {
      return 1;
    }

    // Initialize with 1 all array
    // element
    for(int i = 0; i < n; i++)
      ans[i] = 1;

    // Traverse the array arr[]
    for(int i = 0; i < n - 1; i++)
    {

      // If arr[i+1] is greater than
      // arr[i]
      if (arr[i + 1] > arr[i])
      {

        // Assign ans[i]+1 to
        // ans[i+1]
        ans[i + 1] = ans[i] + 1;
      }
    }

    // Iterate until i is atleast 0
    for(int i = n - 2; i >= 0; i--)
    {

      // If arr[i] is greater than
      // arr[i+1] and ans[i] is
      // at most ans[i+1]
      if (arr[i] > arr[i + 1] &&
          ans[i] <= ans[i + 1])
      {

        // Assign ans[i+1]+1 to
        // ans[i]
        ans[i] = ans[i + 1] + 1;
      }

      // Increment the sum by ans[i]
      sum += ans[i];
    }

    sum += ans[n - 1];

    // Return the resultant sum
    return sum;
  }

  // Driver Code
  public static void main(String[] args)
  {
    int arr[] = {3,2,3};
    int N = arr.length;

    System.out.println(countCandies(arr, N));
  }
}

