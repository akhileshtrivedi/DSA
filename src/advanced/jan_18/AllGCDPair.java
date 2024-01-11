package advanced.jan_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AllGCDPair {
  static int gcd(int b,int c){
    if(c==0)
      return b;
    return gcd(c, b%c);
  }


  public static ArrayList<Integer> solve(ArrayList<Integer> A) {
    ArrayList<Integer> result = new ArrayList<>();
    int n = A.size();
    Collections.sort(A);
    Collections.reverse(A);
    int freq[] = new int[A.get(0) + 1];

    for (int i = 0; i < n; i++)
    {
      freq[A.get(i)]++;
    }

    int  x, l = 0;

    for (int i = 0; i < n; i++)
    {
      if (freq[A.get(i)] > 0)
      {
        result.add(A.get(i));
        freq[result.get(l)]--;
        l++;
        for (int j = 0; j < l; j++)
        {
          if (i != j)
          {
            x = gcd(A.get(i), result.get(j));
            freq[x] -= 2;
          }
        }
      }
    }
    Collections.reverse(result);
    return result;
  }

  // reverse array
  public static void reverse(int[] input)
  {
    int last = input.length - 1;
    int middle = input.length / 2;
    for (int i = 0; i <= middle; i++)
    {
      int temp = input[i];
      input[i] = input[last - i];
      input[last - i] = temp;
    }
  }

  static int __gcd(int a, int b)
  {
    if (b == 0)
    {
      return a;
    }
    return __gcd(b, a % b);

  }
  public static void main(String[] args) {
   // int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
    //    1, 1, 1, 5, 5, 5, 7, 10, 12, 2, 2};
   // int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 7, 10, 12, 2, 2};
   // int arr2[] = {2, 2, 2, 2, 8, 2, 2, 2, 10};//2, 8, 10
   // int arr3[] = {5, 5, 5, 15};//5,15
   // int arr4[] = { 1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11 };//11 14 22 23 31
    System.out.println("first"+solve(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10))));
   // System.out.println("second"+solve(new ArrayList<>(Arrays.asList(5, 5, 5, 15))));
   // System.out.println("Third"+solve(new ArrayList<>(Arrays.asList(1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11 ))));
   // findNumbers(arr);
  //  System.out.println("second");
   // findNumbers(arr2);
   // System.out.println("Third");
    //findNumbers(arr3);
   // System.out.println("Fourth");
   // findNumbers(arr4);

   // System.out.println("Element occurring once is " +
   //     solve(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10))) + " ");
   // System.out.println("Element occurring once is " +
      //  solve(new ArrayList<>(Arrays.asList(2, 2, 2, 2, 8, 2, 2, 2, 10))) + " ");

  }

}
