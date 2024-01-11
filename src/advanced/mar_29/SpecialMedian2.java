package advanced.mar_29;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class SpecialMedian2 {

  /* public static void streamMed(int A[], int N)
    {
      PriorityQueue<Double> g = new PriorityQueue<>();
      PriorityQueue<Double> s = new PriorityQueue<>();
      for (int i = 0; i < N; i++) {

        // Negation for treating it as max heap
        s.add(-1.0 * A[i]);
        g.add(-1.0 * s.poll());
        if (g.size() > s.size())
          s.add(-1.0 * g.poll());

        if (g.size() != s.size())
          System.out.println(-1.0 * s.peek());
          System.out.println((g.peek() - s.peek())
              / 2);
      }
    }*/
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
  PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

  public double[] medianSlidingWindow(int[] nums, int k) {
    //result array would contain length - k + 1 elements
    double[] result = new double[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {

      insert(nums[i]);

      //if we have at least k elements
      if (i - k + 1 >= 0) {
        result[i - k + 1] = findMedian();
        int elementToBeRemoved = nums[i - k + 1];
        remove(elementToBeRemoved);
      }
    }
    return result;
  }

  //1- define  Insert method
  public void insert(int x) {
    // if X is smaller than the middle value or if maxHeap is empty
    if (maxHeap.isEmpty() || maxHeap.peek() >= x) {
      maxHeap.add(x);
    }

    // if X is greater than the middle value
    else {
      minHeap.add(x);
    }
    balanceHeaps();
  }

  // 2- define remove method
  public void remove(int x) {
//element exists in maxHeap
    if (x <= maxHeap.peek()) {
      maxHeap.remove(x);
    }
// element exists in MinHeap
    else {
      minHeap.remove(x);
    }
    balanceHeaps();
  }

  // 3 define balanceHeaps method
  public void balanceHeaps() {

    //if maxHeap has more than 1 element than minHeap
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    }

    //if maxHeap has less elements than minHeap
    else if (maxHeap.size() < minHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  // 4-  define findMedian
  public double findMedian() {

    //if even number of elements exist
    if (maxHeap.size() == minHeap.size()) {
      return ((double) maxHeap.peek() + minHeap.peek()) / 2;
    }
    //if odd number of elements exist
    else {
      return maxHeap.peek();
    }
  }

  int solve(ArrayList<Integer> A) {
    int n = A.size();
    int left = 0;
    int right = 0;
    int ans = 0;
    System.out.println("" + A);
    for (int i = 0; i < A.size(); i++) {

      left = i - 1;
      right = i + 1;
      System.out.println(" ith element->" + A.get(i));
      System.out.println(left+" ith element->" + right);
      insert(A.get(i));
      int a=maxHeap.peek();
      int b=minHeap.peek();

//      for (int j = left; j >= 0; j--) {
//        insert(A.get(j));
//        System.out.println(" left element->" + A.get(j));
//      }
//      for (int j = right; j < n; j++) {
//        System.out.println(" right element->" + A.get(j));
//      }
    }
    return ans;
  }

  // Driver code
  public static void main(String[] args) {
    // int A[] = {4, 6, 8, 4};
    //2, 7, 3, 1
    int A[] = {1, 2, 5, 4, 3};
    int N = A.length;

    // Function call
    //streamMed(A, N);
    SpecialMedian2 sm = new SpecialMedian2();

    System.out.println(" I am here" + sm.solve(new ArrayList<>(Arrays.asList(4, 6, 8, 4))));
    //sm.streamMed(A, N);
  }
}
