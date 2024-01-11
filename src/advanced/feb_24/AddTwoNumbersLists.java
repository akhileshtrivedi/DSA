package advanced.feb_24;

import java.util.*;

class AddTwoNumbersLists {

  static Node head1, head2;

  static class Node {

    int data;
    Node next;

    Node(int d)
    {
      data = d;
      next = null;
    }
  }
  // function to reverse the linked list and return the
  // head of the reversed list
  static Node reverseList(Node list)
  {
    Node prev = null, curr = list, next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
  // function that calculates and prints the sum of two
  // numbers represented
  // by linked lists

  static void addTwoLists(Node first, Node second)
  {
    // code here
    first = reverseList(first);
    second = reverseList(second);
    printList(first);
    printList(second);

    int carry = 0;
    Node head = null, prev = null;
    Node sum = null;

    while (first != null || second != null
        || carry
        == 1)
    {
      int newVal = carry;

      if (first != null)
        newVal += first.data;
      if (second != null)
        newVal += second.data;

      carry = newVal / 10;
      newVal = newVal % 10;

      Node newNode = new Node(newVal);
      newNode.next
          = sum;
      sum = newNode;

      if (first != null)
        first = first.next;
      if (second != null)
        second = second.next;
    }
    sum = reverseList(sum);
    printList(sum);
  }

  static void printList(Node head)
  {
    while (head.next != null) {
      System.out.print(head.data + " -> ");
      head = head.next;
    }
    System.out.println(head.data);
  }
  public Node addTwoNumbers(Node l1, Node l2) {
    // Start typing your Java solution below
    // DO NOT write main() function
    return calculate(l1, l2, 0);
  }

  Node calculate(Node l1, Node l2, int carry)
  {
    if(l1==null&&l2==null&&carry==0) return null;
    if(l1==null&&l2==null&&carry!=0) return new Node(1);
    int temp=(l1==null? 0: l1.data)+ (l2==null? 0: l2.data)+ carry;
    Node result=new Node(temp%10);
    result.next=calculate(l1==null? null: l1.next, l2==null? null: l2.next, temp/10);
    return result;
  }
  // Driver Code
  public static void main(String[] args)
  {
    AddTwoNumbersLists list = new AddTwoNumbersLists();

    // creating first list
    list.head1 = new Node(9);
    list.head1.next = new Node(9);
    list.head1.next.next = new Node(1);
   // list.head1.next.next.next = new Node(4);
   // list.head1.next.next.next.next = new Node(6);

    // creating second list
    list.head2 = new Node(1);
    //list.head2.next = new Node(6);
   // list.head2.next.next = new Node(4);

    System.out.print("Sum List : ");
    // add the two lists and see the result
    //list.addTwoNumbers(head1, head2);
    printList(list.addTwoNumbers(head1, head2));
  }

}
