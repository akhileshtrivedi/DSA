package advanced.mar_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

class KPlacesApart {
  private static ArrayList<Integer> kSort(ArrayList<Integer> A, int B)
  {
    ArrayList<Integer> ans = new ArrayList<>();
    int n= A.size();
    if (A.isEmpty()) {
      return ans;
    }

    PriorityQueue<Integer> priorityQueue
        = new PriorityQueue<>();

    int minCount = Math.min(n, B + 1);
    // add first k + 1 items to the min heap
    for (int i = 0; i < minCount; i++) {
      priorityQueue.add(A.get(i));
    }

    int index = 0;

    for (int i = B + 1; i < n; i++) {
      ans.add(priorityQueue.peek());
      priorityQueue.poll();
      priorityQueue.add(A.get(i));
    }

    Iterator<Integer> itr = priorityQueue.iterator();

    while (itr.hasNext()) {
      ans.add(priorityQueue.peek());
      priorityQueue.poll();
    }
    return ans;
  }

  private static void printArray(int[] arr, int n)
  {
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
  }

  // Driver Code
  public static void main(String[] args)
  {
    int k = 1;//1, 40, 2, 3
    int arr[] = { 2, 1, 17, 10, 21, 95};
    int n = arr.length;

    // function call
    System.out.println(""+kSort(new ArrayList<>(Arrays.asList(2, 1, 17, 10, 21, 95)),1));
   // kSort(arr, n, k);
  //  printArray(arr, n);
  }
}

// This code is contributed by
// Manpreet Singh(manpreetsngh294)
