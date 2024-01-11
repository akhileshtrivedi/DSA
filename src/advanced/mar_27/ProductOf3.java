package advanced.mar_27;

import java.util.*;

class ProductOf3{

  // Function to find a maximum product of
// a triplet in array of integers of size n
  static int maxProduct(int []arr, int n)
  {

    // If size is less than 3, no triplet exists
    if (n < 3)
      return -1;

    // Initialize Maximum, second maximum
    // and third maximum element
    int maxA = Integer.MIN_VALUE,
        maxB = Integer.MIN_VALUE,
        maxC = Integer.MIN_VALUE;

    // Initialize Minimum and
    // second minimum element
    int minA = Integer.MAX_VALUE,
        minB = Integer.MAX_VALUE;

    for(int i = 0; i < n; i++)
    {

      // Update Maximum, second maximum
      // and third maximum element
      if (arr[i] > maxA)
      {
        maxC = maxB;
        maxB = maxA;
        maxA = arr[i];
      }

      // Update second maximum and
      // third maximum element
      else if (arr[i] > maxB)
      {
        maxC = maxB;
        maxB = arr[i];
      }

      // Update third maximum element
      else if (arr[i] > maxC)
        maxC = arr[i];

      // Update Minimum and second
      // minimum element
      if (arr[i] < minA)
      {
        minB = minA;
        minA = arr[i];
      }

      // Update second minimum element
      else if(arr[i] < minB)
        minB = arr[i];
    }
    System.out.println(minA+"  "+minB+"  "+maxA);
    System.out.println(maxA+"  "+maxB+"  "+maxC);
    return Math.max(minA * minB * maxA,
        maxA * maxB * maxC);
  }

  // Driver code
  public static void main(String[] args)
  {
    int []arr = { 1, 2, 3, 4, 5};
    int n = arr.length;

    int max = maxProduct(arr, n);

    if (max == -1)
      System.out.print("No Triplet Exists");
    else
      System.out.print("Maximum product is " + max);
  }
}

