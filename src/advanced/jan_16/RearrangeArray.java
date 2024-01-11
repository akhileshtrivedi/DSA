package advanced.jan_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RearrangeArray {

  void rearrangeOLD(int arr[], int n)
  {
    // First step: Increase all values by
    // (arr[arr[i]]%n)*n
    for (int i = 0; i < n; i++) {
      arr[i] += (arr[arr[i]] % n) * n;
    }
    System.out.println("first-->");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    // System.out.println("");
    }
    // Second Step: Divide all values by n
    for (int i = 0; i < n; i++) {
      arr[i] /= n;
    }
    System.out.println("second-->");
      for (int i = 0; i < n; i++) {
        System.out.print(arr[i] + " ");
       // System.out.println("");
      }
  }
  void rearrange(int arr[])
  {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      arr[i] += (arr[arr[i]] % n) * n;
    }

    // Second Step: Divide all values by n
    for (int i = 0; i < n; i++) {
      arr[i] /= n;
    }
  }
  // A utility function to print an array of size n
  void printArr(int arr[])
  {
    int n = arr.length;
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
    System.out.println("");
  }

  /* Driver program to test above functions */

  private static void arrange(ArrayList<Integer> a) {
    Integer[] arr=new Integer[a.size()];
    arr= a.toArray(arr);
   int n =a.size();
    for (int i = 0; i < n; i++) {
      arr[i] += (arr[arr[i]] % n) * n;
    }

    // Second Step: Divide all values by n
    for (int i = 0; i < n; i++) {
      arr[i] /= n;
    }
    a.clear();
    Collections.addAll(a, arr);
    System.out.println("second-AL->"+a);
  }
  static void  printList(ArrayList<Integer> a)
  {
    for (int i = 0; i < a.size(); i++)
      System.out.print(a.get(i)+ " ");
    System.out.println("");
  }
  public static void main(String[] args)
  {
    RearrangeArray rearrange = new RearrangeArray();
   // int arr[] = { 4, 0, 2, 1, 3 };
    int arr[] = { 0, 2, 1, 3 };
    int n = arr.length;
 ArrayList<Integer> al = new ArrayList<>(Arrays.asList(4, 0, 2, 1, 3 ));
    System.out.println("Given Array is :");
   // rearrange.printArr(arr, n);
    arrange(al);
   // rearrange.rearrange(arr);
   // rearrange.printArr(arr);
   // printList(al);
  //  System.out.println("Modified Array is :"+printList(al));
   // rearrange.printArr(arr, n);

  }
}

// This code has been contributed by Mayank Jaiswal
