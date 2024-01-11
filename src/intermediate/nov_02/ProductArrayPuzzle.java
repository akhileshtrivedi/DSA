package intermediate.nov_02;

import java.util.ArrayList;
import java.util.Arrays;

// Java program for product array puzzle
// with O(n) time and O(1) space.
public class ProductArrayPuzzle {

    // epsilon value to maintain precision
    static final double EPS = 1e-9;

    static void productPuzzle(int a[], int n)
    {
        // to hold sum of all values
        double sum = 0;
        for (int i = 0; i < n; i++)
            sum += Math.log10(a[i]);

        // output product for each index
        // anti log to find original product value

        System.out.println("Sum --->"+sum);
        for (int i = 0; i < n; i++)
            System.out.print(
                    (int)(EPS
                            + Math.pow(
                            10.00, sum
                                    - Math.log10(a[i])))
                            + " ");

  System.out.println("Sum ---> Done");
    }
   private  static ArrayList<Integer> solve(ArrayList<Integer> A)
    {
        ArrayList<Integer> result = new ArrayList<>(0);
        int n=A.size();
        double sum = 0;

        for (int i = 0; i < n; i++)
            sum += Math.log10(A.get(i));

        for (int i = 0; i < n; i++)
            result.add(
                    (int)(EPS
                            + Math.pow(
                            10, sum
                                    - Math.log10(A.get(i))))
                            );

    return  result;
    }
    // Driver code
    public static void main(String args[])
    {
        /*
        Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    [120, 60, 40, 30, 24]

Input 2:
    A = [5, 1, 10, 1]
Output 2:
    [10, 50, 5, 50]
         */

        int a[] = { 1, 2, 3, 4, 5 };
        int a2[] = { 5, 1, 10, 1};
        int n = a.length;
        int n2 = a2.length;
        System.out.println("The product array is: "+solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5 ))));
        System.out.println("The product array is: "+solve(new ArrayList<>(Arrays.asList(3, 2, 10, 1, 4, 7, 7, 1, 10, 2, 6, 6, 7, 6, 5, 1, 1, 1, 1 ))));
        // productPuzzle(a, n);
        //productPuzzle(a2, n2);
    }
}
// This code is contributed by Sumit Ghosh
