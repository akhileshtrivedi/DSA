package advanced.mar_29;

import java.io.*;
    import java.util.*;

class MedianMy {

  // Function to find the median of stream of data
  public static void streamMed(int A[], int N)
  {
    PriorityQueue<Double> g = new PriorityQueue<>();
    PriorityQueue<Double> s = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      s.add(-1.0 * A[i]);
      g.add(-1.0 * s.poll());
      if (g.size() > s.size())
        s.add(-1.0 * g.poll());

      if (g.size() != s.size())
        System.out.println(-1.0 * s.peek());
      else
        System.out.println((g.peek() - s.peek())
            / 2);
    }
  }
  public static void streamMedian(ArrayList<Integer> list)
  {
    PriorityQueue<Double> g = new PriorityQueue<>();
    PriorityQueue<Double> s = new PriorityQueue<>();
    PriorityQueue<Double> gMax = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Double> sMax = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < list.size(); i++) {
      s.add(-1.0 * list.get(i));
      g.add(-1.0 * s.poll());
      if (g.size() > s.size())
        s.add(-1.0 * g.poll());

      if (g.size() != s.size())
        System.out.println(-1.0 * s.peek());
      else
        System.out.println((g.peek() - s.peek())
            / 2);
    }
  }

  // Driver code
  public static void main(String[] args)
  {
    int A[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
    int N = A.length;

    // Function call
   // streamMed(A, N);
   // streamMedian(new ArrayList<Integer>(Arrays.asList(5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 )));
    streamMedian(new ArrayList<Integer>(Arrays.asList(1, 2, 5, 4, 3)));
  }
}
