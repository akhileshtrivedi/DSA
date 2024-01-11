package advanced.feb_27;


// A complete working java program to
// demonstrate all stack operations using
// a doubly linked list

import java.util.ArrayList;
import java.util.Arrays;

class Mystack {

  static class Node {
    int data;
    Node prev;
    Node next;
  };

  static Node start = null;
  static Node top = null;

  // Check if stack is empty
  public static boolean isEmpty() {
    if (start == null)
      return true;
    return false;
  }

  // pushes element onto stack
  public static void push(int d) {
    Node n;
    n = new Node();
    n.data = d;
    if (isEmpty()) {
      n.prev = null;
      n.next = null;

      // As it is first node if stack
      // is empty
      start = n;
      top = n;
    } else {
      top.next = n;
      n.next = null;
      n.prev = top;
      top = n;
    }
  }

  // Pops top element from stack
  public static int pop() {
    int data = -1;
    Node n;
    n = top;
    if (isEmpty())
      System.out.println("Stack is empty");
    else if (top == start) {
      data=top.data;
      top = null;
      start = null;
      n = null;
    } else {
      data = n.data;
      top.prev.next = null;
      top = n.prev;
      n = null;
    }
    System.out.println("pop data-->"+data);
    return data;
  }

  // Prints top element of the stack
  public static void topelement() {
    if (isEmpty())
      System.out.println("Stack is empty");
    else
      System.out.println("The element at top of the stack is : " + top.data);
  }

  // Determines the size of the stack
  public static void stacksize() {
    int c = 0;
    if (isEmpty())
      System.out.println("Stack is empty");
    else {
      Node ptr = start;
      while (ptr != null) {
        c++;
        ptr = ptr.next;
      }
    }
    System.out.println("Size of the stack is : " + c);
  }

  // Determines the size of the stack
  public static void printstack() {
    if (isEmpty())
      System.out.println("Stack is empty");
    else {
      Node ptr = start;
      System.out.print("Stack is : ");
      while (ptr != null) {
        System.out.print(ptr.data + " ");
        ptr = ptr.next;
      }
      System.out.println("");
    }
  }
  private static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
    ArrayList<Integer> ans = new ArrayList<>();
   // MiddleElementFromStack mes = new MiddleElementFromStack();
    int type = 0;
    for (ArrayList obj : A) {

      type = (int) obj.get(0);
      switch (type) {
        case 1:
          push((int) obj.get(1));
          System.out.println(" after  pushing--> "+obj.get(1));
          //mes.display();
          break;
        case 2:
          printstack();
          ans.add(pop());
          break;
        case 3:
         // ans.add(mes.findMiddle());
          break;
        case 4:
         // mes.deleteMiddleElement();
          break;
        default:
          System.out.println(" invalid operation type");
      }
      System.out.println("ans-->"+ans);
    }

    return ans;
  }
  // Driver code
  public static void main(String args[]) {
    ArrayList<ArrayList<Integer>> A = new ArrayList<>();//[3, -1, 9]
    A.add(new ArrayList<>(Arrays.asList(1, 548)));
    A.add(new ArrayList<>(Arrays.asList(1, 663)));
    A.add(new ArrayList<>(Arrays.asList(2, 0)));
    A.add(new ArrayList<>(Arrays.asList(2, 0)));
    A.add(new ArrayList<>(Arrays.asList(4, 0)));
    A.add(new ArrayList<>(Arrays.asList(4, 0)));
    A.add(new ArrayList<>(Arrays.asList(2, 0)));
    A.add(new ArrayList<>(Arrays.asList(2, 0)));
    A.add(new ArrayList<>(Arrays.asList(3, 0)));
    A.add(new ArrayList<>(Arrays.asList(1, 36)));
    System.out.println(" output---> " + solve(A));
   /* push(2);
    push(5);
    push(10);
    printstack();
    topelement();
    stacksize();
    pop();
    System.out.println("\nElement popped from the stack ");
    topelement();
    pop();
    System.out.print("\nElement popped from the stack \n");
    stacksize();*/
  }
}

// This code is contributed by Saurabh Jaiswal

