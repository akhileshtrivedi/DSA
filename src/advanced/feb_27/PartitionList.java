package advanced.feb_27;

class PartitionList {

  static class ListNode {
    int val;
    ListNode next;
  }

  static ListNode newNode(int x) {
    ListNode new_node = new ListNode();
    new_node.val = x;
    new_node.next = null;
    return new_node;
  }

  static ListNode partition(ListNode A, int B) {
    ListNode smallerHead = null, smallerLast = null;
    ListNode greaterLast = null, greaterHead = null;
    ListNode equalHead = null, equalLast = null;

    while (A != null) {
      if (A.val < B) {
        if (smallerHead == null) {
          smallerLast = smallerHead = A;
        } else {
          smallerLast.next = A;
          smallerLast = A;
        }
      } else {
        if (greaterHead == null) {
          greaterLast = greaterHead = A;
        } else {
          greaterLast.next = A;
          greaterLast = A;
        }
      }
      A = A.next;
    }

    if (greaterLast != null) {
      greaterLast.next = null;
    }

    if (smallerHead == null) {
      if (equalHead == null) {
        return greaterHead;
      }
      equalLast.next = greaterHead;
      return equalHead;
    }

    if (equalHead == null) {
      smallerLast.next = greaterHead;
      return smallerHead;
    }

    smallerLast.next = equalHead;
    equalLast.next = greaterHead;
    return smallerHead;
  }

  static void printList(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
  }

  public static void main(String[] args) {

    ListNode head = newNode(10);
    head.next = newNode(4);
    head.next.next = newNode(5);
    head.next.next.next = newNode(30);
    head.next.next.next.next = newNode(2);
    head.next.next.next.next.next = newNode(50);

    int x = 3;
    head = partition(head, x);
    printList(head);
  }

}
