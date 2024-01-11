package advanced.feb_24;


import java.util.HashSet;

public class RemoveLoopFromLinkedList {

  static Node head; // head of list

  /* Linked list Node*/
  static class Node {

    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  static public void push(int new_data) {

    Node new_node = new Node(new_data);
    new_node.next = head;
    head = new_node;
  }

  void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  static boolean removeLoop(Node h) {
    HashSet<Node> s = new HashSet<Node>();
    Node prev = null;
    while (h != null) {
      if (s.contains(h)) {
        prev.next = null;
        return true;
      } else {
        s.add(h);
        prev = h;
        h = h.next;
      }
    }
    return false;
  }

  public Node solve(Node A) {
    HashSet<Node> s = new HashSet<Node>();
    Node prev = null;
    while (A != null) {
      if (s.contains(A)) {
        prev.next = null;
        return A;
      } else {
        s.add(A);
        prev = A;
        A = A.next;
      }
    }
    return A;

  }

  public static void main(String[] args) {
    RemoveLoopFromLinkedList llist = new RemoveLoopFromLinkedList();

    llist.push(6);
    llist.push(5);
    llist.push(5);
    llist.push(3);
    llist.push(8);

    llist.head.next.next.next.next = llist.head;
   // System.out.println("No Loop found" + llist.solve(head));
   // llist.printList(llist.solve(head));
   if (removeLoop(head)) {
      System.out.println("Linked List after removing loop");
      llist.printList(head);
    }
    else
      System.out.println("No Loop found");
 // }
  }
}
