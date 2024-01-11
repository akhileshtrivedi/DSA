package advanced.mar_29;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapToArray {

  public static void writeQueue(PriorityQueue<Integer> priorityQueue) {
    while (priorityQueue.size() != 0) {
      System.out.println(priorityQueue.poll());
    }
  }

  public static void writeMaxHeap(PriorityQueue<Integer> priorityQueue) {
    for (Integer element : priorityQueue) {
      System.out.println(element);
    }
  }

  public static void main(String args[]) {
    int[] theArray = {5, 3, 13, 10, 99, 19, 6, 51, 9};

    // theQueue is created
    PriorityQueue<Integer> theQueue =
        new PriorityQueue<Integer>(Collections.reverseOrder());

    // Elements are added to theQueue
    for (int i = 0; i < theArray.length; ++i) {
      theQueue.add(theArray[i]);
    }

 // The head or root element (priority element) is printed out
    System.out.println("The root value is : " + theQueue.peek());

    // Find size of theQueue. Use method size()
    Integer s = theQueue.size();
    System.out.println("Size of theQueue? " + s);

    // All elements of theQueue are printed in terms of parent,
    // left child, right child
  System.out.println("theQueue written using for loop:");
    writeMaxHeap(theQueue);

    // Does theQueue contain 10? Use method contains()
  boolean b = theQueue.contains(10);
    System.out.println("Does theQueue contain 10? " + b);

    // Erasing value 10 from array using remove()
    theQueue.remove(10);

    // All elements of theQueue are printed out and removed.
    // Each one is the maximum value left in the queue.
    // At the end theQueue will be empty
    System.out.println("theQueue written out using poll():");
    writeQueue(theQueue);

    // Find size of theQueue. Use method size()
    s = theQueue.size();
    System.out.println("Size of theQueue? " + s);
  }
}