package advanced.mar_0;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

class MinDifference{

  static Vector<Integer> get_submaxarr(int[] arr, int n, int y)
  {
    int j = 0;
    Stack<Integer> stk = new Stack<Integer>();

    int[] maxarr = new int[n];
    Arrays.fill(maxarr,0);
    stk.push(0);

    for(int i = 1; i < n; i++)
    {

      while (stk.size() != 0 &&
          arr[i] > arr[stk.peek()])
      {
        maxarr[stk.peek()] = i - 1;
        stk.pop();
      }
      stk.push(i);
    }

    while (stk.size() != 0)
    {
      maxarr[stk.size()] = n - 1;
      stk.pop();
    }
    Vector<Integer> submax = new Vector<Integer>();

    for(int i = 0; i <= n - y; i++)
    {

      while (maxarr[j] < i + y - 1 || j < i)
      {
        j++;
      }
      submax.add(arr[j]);
    }

    return submax;
  }

  static Vector<Integer> get_subminarr(int[] arr, int n, int y)
  {
    int j = 0;

    Stack<Integer> stk = new Stack<Integer>();

    int[] minarr = new int[n];
    Arrays.fill(minarr,0);
    stk.push(0);
    System.out.println(stk+"    "+Arrays.toString(arr));
    for(int i = 1; i < n; i++)
    {
      while (stk.size() != 0 &&
          arr[i] < arr[stk.peek()])
      {
        minarr[stk.peek()] = i;
        stk.pop();
      }
      stk.push(i);
    }

    while (stk.size() != 0)
    {
      minarr[stk.peek()] = n;
      stk.pop();
    }

    Vector<Integer> submin = new Vector<Integer>();

    for(int i = 0; i <= n - y; i++)
    {
      while (minarr[j] <= i + y - 1 || j < i)
      {
        j++;
      }
      submin.add(arr[j]);
    }

    return submin;
  }

  static void getMinDifference(int[] Arr, int N, int Y)
  {
    Vector<Integer> submin = get_subminarr(Arr, N, Y);
    Vector<Integer> submax = get_submaxarr(Arr, N, Y);
    int minn = submax.get(0) - submin.get(0);
    int b = submax.size();
    System.out.println(submax+"-->"+submin);
    for(int i = 1; i < b; i++)
    {
      int dif = submax.get(i) - submin.get(i) + 1;
      System.out.println("dif-->"+dif);
      minn = Math.min(minn, dif);
    }
    System.out.println("dif-->");
    System.out.print(minn);
  }
  public static void main(String[] args)
  {
    int[] arr = { 4, 7, 3, 8 };
    int N = arr.length;
    int Y = 4;
    getMinDifference(arr, N, Y);
  }
}

