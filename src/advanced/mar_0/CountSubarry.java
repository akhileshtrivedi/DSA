package advanced.mar_0;


import java.util.ArrayList;
import java.util.Arrays;

class CountSubarry {

  // function to calculate N*(N+1)/2
 /* static long countSubarrys(long n)
  {
    return n * (n + 1) / 2;
  }

  // function to count the number of
// sub-arrays with maximum greater
// then L and less than R.
  static long countSubarrays(int a[], int n,
      int L, int R)
  {
    long res = 0;
    long exc = 0, inc = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] > R) {
        res += (countSubarrys(inc) - countSubarrys(exc));
        inc = 0;
        exc = 0;
      }
      else if (a[i] < L) {
        exc++;
        inc++;
      }
      else {
        res -= countSubarrys(exc);
        exc = 0;
        inc++;
      }
    }
    res += (countSubarrys(inc) - countSubarrys(exc));
    return res;
  }*/
  static int calculateSubArraysValue(int[] arr, int head, int tail, int result) {
    if (tail == arr.length)
      return result;

    else if (head > tail)
      calculateSubArraysValue(arr, 0, tail + 1, result);
    else {
      int ans[]= new int[tail+1];
      for (int i = head; i < tail; i++) {
        ans[i]=arr[i];
      }
      ans[tail]=arr[tail];
       Arrays.sort(ans);
      if(ans.length==1 ||(ans.length>1 && ans[0]==0 && ans[1]==0 && ans[2]==0)) {
        result=result+0;
      } else if (ans.length>1 && ans[0]>0 ) {
        result=result+(ans[tail]-ans[0]);
      }
      System.out.println("result--> "+result);
      calculateSubArraysValue(arr, head + 1, tail, result);
    }
    return result;
  }

  /*
  static int findMaxSum(int arr[], int n)
  {
    int CL[] = new int[n], CR[] = new int[n];
    Stack<Integer> q = new Stack<Integer>();

    for (int i = 0; i < n; i++)
    {
      while (q.size() != 0 && arr[q.peek()] <= arr[i])
      {
        CL[i] += CL[q.peek()] + 1;
        q.pop();
      }
      q.push(i);
    }
    while (q.size() != 0)
      q.pop();

    for (int i = n - 1; i >= 0; i--)
    {
      while (q.size() != 0 && arr[q.peek()] < arr[i])
      {
        CR[i] += CR[q.peek()] + 1;
        q.pop();
      }
      q.push(i);
    }
    while (q.size() != 0)
      q.pop();

    int ans = 0;

    for (int i = 0; i < n; i++) {
      System.out.println((CL[i] + 1)+"   "+ (CR[i] + 1)+"    "+ arr[i]);
      ans += (CL[i] + 1) * (CR[i] + 1) * arr[i];
    }

    return ans;
  }
  static int findMinSum(int arr[], int n)
  {
    int CL[] = new int[n], CR[] = new int[n];
    Stack<Integer> q = new Stack<Integer>();

    for (int i = 0; i < n; i++)
    {
      while (q.size() != 0 && arr[q.peek()] >= arr[i])
      {
        CL[i] += CL[q.peek()] + 1;
        q.pop();
      }
      q.push(i);
    }

    while (q.size() != 0)
      q.pop();

    for (int i = n - 1; i >= 0; i--)
    {
      while (q.size() != 0 && arr[q.peek()] > arr[i])
      {
        CR[i] += CR[q.peek()] + 1;
        q.pop();
      }
      q.push(i);
    }

    while (q.size() != 0)
      q.pop();

    int ans = 0;

    for (int i = 0; i < n; i++) {
      System.out.println((CL[i] + 1) + "   " + (CR[i] + 1) + "    " + arr[i]);
      ans += (CL[i] + 1) * (CR[i] + 1) * arr[i];
    }
    return ans;
  }
*/
  // Driver code
  public static void main(String arg[])
  {
    int a[] = {4, 7, 3, 8};
    int n = a.length;
   // printSubArrays(a, 0,0);
   // int arr[] = { 2,5, 3 };
   // int n = arr.length;
  //  System.out.println(findMaxSum(arr, n));
  //  System.out.println(findMinSum(arr, n));
    int[] arr = { 4, 7, 3, 8};
    System.out.println("printSubArrays-->    "+ calculateSubArraysValue(arr, 0, 0, 0));
    ArrayList<Integer> AA = new ArrayList<>(Arrays.asList(2,3,4,5));
    int A[] = AA.stream().mapToInt(i->i).toArray();
  }
}

// This code is contributed by Anant Agarwal.
