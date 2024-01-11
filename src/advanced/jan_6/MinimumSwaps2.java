package advanced.jan_6;
import java.io.*;
import java.util.*;
public class MinimumSwaps2 {
/*
  private static  int solve(ArrayList<Integer> A) {
    int N = A.size();
    int ans = 0;
    ArrayList<Integer>  temp = new ArrayList<>(A);
    HashMap<Integer, Integer> h
        = new HashMap<Integer, Integer>();

    Collections.sort(temp);
    for (int i = 0; i < N; i++) {
      h.put(A.get(i), i);
    }
    for (int i = 0; i < N; i++) {

      if (A.get(i) != temp.get(i)) {
        ans++;
        int init = A.get(i);
       // System.out.println("before swap-->"+A);
      //  Collections.swap(A, i, h.get(temp.get(i)));
       // System.out.println("After swap-->"+A);
        h.put(init, h.get(temp.get(i)));
        h.put(temp.get(i), i);
      }
    }
    return ans;
  }

  private static int minSwaps(int[] arr)
  {
    int N = arr.length;
    int ans = 0;
    int[] temp = Arrays.copyOfRange(arr, 0, N);

    HashMap<Integer, Integer> h
        = new HashMap<Integer, Integer>();

    Arrays.sort(temp);
    for (int i = 0; i < N; i++) {
      h.put(arr[i], i);
    }
/*
    for (int i = 0; i < temp.length; i++) {
      System.out.println("temp-->"+temp[i]);
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.println("arr-->"+arr[i]);
    }*/
/*
    System.out.println(h);
    for (int i = 0; i < N; i++) {

      if (arr[i] != temp[i]) {
        ans++;
        int init = arr[i];

        //swap(arr, i, h.get(temp[i]));
        h.put(init, h.get(temp[i]));
        h.put(temp[i], i);
      }
    }
    return ans;
  }
  public static void  swap(int[] arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  } */
private static int minSwaps(int[] arr)
{
  int N = arr.length;
  int ans = 0;
  int[] temp = Arrays.copyOfRange(arr, 0, N);
  HashMap<Integer, Integer> h
      = new HashMap<Integer, Integer>();

  Arrays.sort(temp);
  for (int i = 0; i < N; i++) {
    h.put(arr[i], i);
  }
  for (int i = 0; i < N; i++) {
    if (arr[i] != temp[i]) {
      ans++;
      int init = arr[i];
      swap(arr, i, h.get(temp[i]));
      h.put(init, h.get(temp[i]));
      h.put(temp[i], i);
    }
  }
  return ans;
}

  private static int solve(ArrayList<Integer> A) {
    int N = A.size();
    int ans = 0;
    ArrayList<Integer>  temp = new ArrayList<>(A);
    HashMap<Integer, Integer> h
        = new HashMap<Integer, Integer>();
    Collections.sort(temp);
    for (int i = 0; i < N; i++) {
      h.put(A.get(i), i);
    }
    for (int i = 0; i < N; i++) {
      if (A.get(i) != temp.get(i)) {
        ans++;
        int init = A.get(i);
        Collections.swap(A, i, h.get(temp.get(i)));
        h.put(init, h.get(temp.get(i)));
        h.put(temp.get(i), i);
      }
    }
    return ans;
  }
  private static void swap(int[] arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  public static void main(String[] args) throws Exception
  {
    int[] a
        = {1, 2, 3, 4, 0 };
    System.out.println(minSwaps(a));

    System.out.println(" here"+solve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 0 ))));
  }
}
// This code is contributed by Satvik Nema
