package intermediate.nov_02;

import java.util.ArrayList;
import java.util.Arrays;

class ProductArray {
    /* Function to print product array
    for a given array arr[] of size n */
    void productArray(int arr[], int n) {

        // Base case
        if (n == 1) {
            System.out.print(0);
            return;
        }
        // Initialize memory to all arrays
        int left[] = new int[n];
        int right[] = new int[n];
        int prod[] = new int[n];

        int i, j;

		/* Left most element of left array
is always 1 */
        left[0] = 1;

		/* Right most element of right
array is always 1 */
        right[n - 1] = 1;

        /* Construct the left array */
        for (i = 1; i < n; i++)
            left[i] = arr[i - 1] * left[i - 1];

        /* Construct the right array */
        for (j = n - 2; j >= 0; j--)
            right[j] = arr[j + 1] * right[j + 1];

		/* Construct the product array using
		left[] and right[] */
        for (i = 0; i < n; i++)
            prod[i] = left[i] * right[i];

        /* print the constructed prod array */
        for (i = 0; i < n; i++)
            System.out.print(prod[i] + " ");

        return;
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>(0);
        int n = A.size();
        Integer[] arr = new Integer[A.size()];
        arr = A.toArray(arr);

        if (n == 1) {
            System.out.print(0);
            return result;
        }

        int left[] = new int[n];
        int right[] = new int[n];
        int prod[] = new int[n];

        int i, j;
        left[0] = 1;
        right[n - 1] = 1;

        for (i = 1; i < n; i++)
            left[i] = arr[i - 1] * left[i - 1];

        for (j = n - 2; j >= 0; j--)
            right[j] = arr[j + 1] * right[j + 1];

        for (i = 0; i < n; i++)
            result.add(left[i] * right[i]);

        return result;
    }

    /* Driver program to test the above function */
    public static void main(String[] args) {
        ProductArray pa = new ProductArray();
        int arr[] = {3, 2, 10, 1, 4, 7, 7, 1, 10, 2, 6, 6, 7, 6, 5, 1, 1, 1, 1};
        int n = arr.length;
        // System.out.println("The product array is : ");
        //   pa.productArray(arr, n);
        System.out.println("The product array is: " + solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))));
        System.out.println("The product array is: " + solve(new ArrayList<>(Arrays.asList(3, 2, 10, 1, 4, 7, 7, 1, 10, 2, 6, 6, 7, 6, 5, 1, 1, 1, 1))));

    }
}

// This code has been contributed by Mayank Jaiswal
