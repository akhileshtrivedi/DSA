package advanced.mar_29;

    import java.util.*;

class AthLargestElement {

  static PriorityQueue<Integer> min;


  static ArrayList<Integer> getAllKthNumber(int A, ArrayList<Integer> B)
  {
    ArrayList<Integer> list = new ArrayList<>();
    for (int val : B) {
      if (min.size() < A)
        min.add(val);
      else {
        if (val > min.peek()) {
          min.poll();
          min.add(val);
        }
      }
      if (min.size() >= A)
        list.add(min.peek());
      else
        list.add(-1);
    }
    return list;
  }

  public static void main(String[] args)
  {
    min = new PriorityQueue<>();


    // Function call
    List<Integer> res = getAllKthNumber(2,new ArrayList<>(Arrays.asList(15, 20, 99  , 1)));


      System.out.println("Kth largest element is "
          + res);
  }

  // This code is Contributed by Pradeep Mondal P
}
