package advanced.feb_27;


import java.util.ArrayList;
import java.util.Arrays;



/* Representation of the stack data structure that
supports findMiddle() in O(1) time. The Stack is
implemented using Doubly Linked List. It maintains
pointer to head node, pointer to middle node and
count of nodes */
public class MiddleElementFromStack {
  static class DLLNode {

    DLLNode prev;
    int data;
    DLLNode next;

    DLLNode(int data) {
      this.data = data;
    }
  }
  DLLNode head;
  DLLNode mid;
  DLLNode prev;
  DLLNode next;
  int size;

  /* Function to push an element to the stack */
  void push(int new_data) {
    DLLNode new_node = new DLLNode(new_data);
    if (size == 0) {
      head = new_node;
      mid = new_node;
      size++;
      return;
    }
    head.next = new_node;
    new_node.prev = head;

    head = head.next;
    if (size % 2 != 0) {
      mid = mid.next;
    }
    size++;
  }

  /* Function to pop an element from stack */
  int pop() {
    int data = -1;
    if (size == 0) {
      System.out.println("Stack is empty");
      // return -1;
    }

    if (size != 0) {
      if (size == 1) {
        data = head.data;
        head = null;
        mid = null;
      } else {
        data = head.data;
        head = head.prev;
        head.next = null;
        if (size % 2 == 0) {
          mid = mid.prev;
        }
      }
      size--;
    }
    return data;
  }

  // Function for finding middle of the stack
  int findMiddle() {
    if (size == 0) {
      System.out.println("Stack is empty now");
      return -1;
    }
    return mid.data;
  }

  void deleteMiddleElement() {
    if (size != 0) {
      if (size == 1) {
        head = null;
        mid = null;
      } else if (size == 2) {
        head = head.prev;
        mid = mid.prev;
        head.next = null;
      } else {
        mid.next.prev = mid.prev;
        mid.prev.next = mid.next;
        if (size % 2 == 0) {
          mid = mid.prev;
        } else {
          mid = mid.next;
        }
      }
      size--;
    }
  }

  private static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
    ArrayList<Integer> ans = new ArrayList<>();
    MiddleElementFromStack mes = new MiddleElementFromStack();
    int type = 0;
    for (ArrayList obj : A) {
      type = (int) obj.get(0);
      switch (type) {
        case 1:
          mes.push((int) obj.get(1));
          System.out.println(" before display "+obj.get(1));
          mes.display();
          break;
        case 2:
          ans.add(mes.pop());
          break;
        case 3:
          ans.add(mes.findMiddle());
          break;
        case 4:
          mes.deleteMiddleElement();
          break;
        default:
          System.out.println(" invalid operation type");
      }
    }
    return ans;
  }


  public void display() {
    //Node current will point to head
    DLLNode current = head;
    if (head == null) {
      System.out.println("List is empty");
      return;
    }
    System.out.println("Nodes of doubly linked list: ");
    while (current != null) {
      //Prints each node by incrementing the pointer.

      System.out.print(current.data + " ");
      current = current.next;
    }
  }

  // Driver program to test functions of myStack
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


    ArrayList<ArrayList<Integer>> AA = new ArrayList<>();//[2, 3]
    AA.add(new ArrayList<>(Arrays.asList(1, 1)));
    AA.add(new ArrayList<>(Arrays.asList(1, 2)));
    AA.add(new ArrayList<>(Arrays.asList(1, 3)));
    AA.add(new ArrayList<>(Arrays.asList(3, 0)));
    AA.add(new ArrayList<>(Arrays.asList(4, 0)));
    AA.add(new ArrayList<>(Arrays.asList(3, 0)));
    AA.add(new ArrayList<>(Arrays.asList(4, 0)));

    MiddleElementFromStack ms = new MiddleElementFromStack();

    System.out.println(" output---> " + ms.solve(A));
    // ms.display();
    // ms.solve(AA);
  /*
    ms.push(11);
    ms.push(22);
    ms.push(33);
    ms.push(44);
    ms.push(55);
    ms.push(66);
    ms.push(77);
    ms.push(88);
    ms.push(99);

 System.out.println("Popped : " + ms.pop());
    System.out.println("Popped : " + ms.pop());
    System.out.println("Middle Element : "
        + ms.findMiddle());
    ms.deleteMiddleElement();
    System.out.println("New Middle Element : "
        + ms.findMiddle());*/
  }
}
// This code is contributed by Abhishek Jha
// Updated by Amsavarthan Lv
