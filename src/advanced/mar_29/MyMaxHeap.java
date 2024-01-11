package advanced.mar_29;

import java.util.*;

class MyMaxHeap {
  private Queue<Integer> minHeap, maxHeap;

  MyMaxHeap() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  }

  void add(int num) {
    if (minHeap.size() == maxHeap.size()) {
      maxHeap.offer(num);
      minHeap.offer(maxHeap.poll());
    } else {
      minHeap.offer(num);
      maxHeap.offer(minHeap.poll());
    }
  }

  int getMedian() {
    int median;
    if (minHeap.size() > maxHeap.size()) {
      median = minHeap.peek();
    } else {
      median = (minHeap.peek() + maxHeap.peek()) / 2;
    }
    return median;
  }

  private static void streamMedian(ArrayList<Integer> A){
    MyMaxHeap mx =new MyMaxHeap();
    for(int i=0;i<A.size();i++){
      mx.add(A.get(i));
      System.out.println( mx.getMedian());
    }

  }
  public static void main(String args[])
  {
    streamMedian(new ArrayList<Integer>(Arrays.asList(1, 2, 5, 4, 3)));
  }
}
