package advanced.mar_29;





import java.util.*;

class MinimumLargestElement {
  static class Pair<U, V>
  {
    public final U first;       // first field of a pair
    public final V second;      // second field of a pair

    // Constructs a new Pair with specified values
    private Pair(U first, V second)
    {
      this.first = first;
      this.second = second;
    }

    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair<U, V> of(U a, V b)
    {
      // calls private constructor
      return new Pair<>(a, b);
    }
  }
  //static class Pair<I extends Number, I1 extends Number> {
//  static class Pair<I extends Number, I1 extends Number> {
//    Integer first;
//    Integer second;
//
//    Pair(Integer first, Integer second) {
//      this.first = first;
//      this.second = second;
//    }
//  }
  public static void FirstKelements(int arr[], int size,
      int k)
  {

    PriorityQueue<Integer> minHeap
        = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      minHeap.add(arr[i]);
    }

    for (int i = k; i < size; i++) {

      if (minHeap.peek() > arr[i])
        continue;

      else {
        minHeap.poll();
        minHeap.add(arr[i]);
      }
    }

    Iterator iterator = minHeap.iterator();

    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
  }


  static int minLargest(ArrayList<Integer> A, int B ){
    int[] state = new int[A.size()];
    int ans = 0;
    PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>();
    for (int i = 0; i < A.size(); i++) {
      System.out.println(2 + A.get(i) + "  " + i);
      Pair<Integer, Integer> pp = new Pair<>(2 + A.get(i), i);
      System.out.println(pp.first + "   " + pp.second);
      pq.add(pp);
    }
    while (B >= 0) {
      Pair<Integer, Integer> top = pq.peek();
      state[top.second] = top.first;
      pq.poll();
      pq.add(new Pair(2 + A.get(top.second) + top.first, top.second));
      B--;
    }
    int max_element = state[0];
    for (int i = 0; i < A.size(); i++) {
      max_element = Math.max(max_element, state[i]);

    }
    return ans;
  }
  // Driver code
  public static void main(String[] args)
  {
    int arr[]
        = {5, 1, 4, 2};

    int size = arr.length;

    // Size of Min Heap
    int k = 5;
    System.out.println(""+minLargest(new ArrayList<>(Arrays.asList(5, 1, 4, 2)), 5));
   // FirstKelements(arr, size, k);
  }
}
