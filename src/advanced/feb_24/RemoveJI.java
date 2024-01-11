package advanced.feb_24;

//public class Main {
//
//}


import java.util.HashSet;
import java.util.Set;

public class RemoveJI {

  class Node {

    int data;
    Node next;
  }

  // Utility function to create a new node with the given data and
  // pushes it onto the list's front
  private Node push(Node head, int data) {
    Node node = new Node();
    node.data = data;
    node.next = head;
    return node;
  }

  // Utility function to print a linked list
  private void printList(Node head) {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " —> ");
      curr = curr.next;
    }
    System.out.println("null");
  }

  // Function to identify and remove cycle in a linked list using hashing
  private Node removeCycle(Node head) {
    Node prev = null;
    Node curr = head;
    Set<Node> set = new HashSet<>();
    while (curr != null) {
      if (set.contains(curr)) {
        prev.next = null;
        return head;
      }
      set.add(curr);
      prev = curr;
      curr = curr.next;
    }
    return head;
  }

  public static void main(String[] args) {
    int n = 5;
    Node head = null;
    RemoveJI removeJI = new RemoveJI();
    for (int i = n; i > 0; i--) {
      head = removeJI.push(head, i);
    }
    head.next.next.next.next.next = head.next;
    //removeJI.printList(head);
    //removeJI.removeCycle(head);

    removeJI.printList(removeJI.removeCycle(head));
  }
}