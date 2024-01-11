package advanced.feb_22;

//import advanced.feb_22.LinkedList.Node;

class MyLinkedList {
  class ListNode {
    int value;
    ListNode next;
    public ListNode(int value) {
      this.value = value;
    }
  }

  private ListNode head;
  private ListNode tail;
  private int size;

  /** Initialize your data structure here. */
  public MyLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  /** Get the valueue of the position-th node in the linked list. If the position is invalueid, return -1. */
  public int get(int position) {
    if (position >= size) {
      return -1;
    }
    ListNode p = head;
    for (int i = 0; i < position; i++) {
      p = p.next;
    }
    return p.value;
  }

  /** Add a node of valueue value before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  public void addAtHead(int value) {
    ListNode n = new ListNode(value);
    n.next = head;
    head = n;
    size++;

    if (head.next == null) {
      tail = head;
    }
  }

  public void addAtTail(int value) {
    ListNode n = new ListNode(value);
    if (tail != null) {
      tail.next = n;
    }
    if (tail == null || size == 0) {
      head = n;
    }
    tail = n;
    size++;
  }

  /** Add a node of valueue value before the position-th node in the linked list. If position equals to the length of linked list, the node will be appended to the end of linked list. If position is greater than the length, the node will not be inserted. */
  public void addAtposition(int position, int value) {
    if (position < 0 || position > size) {
      return;
    }
    if (position == 0) {
      addAtHead(value);

    } else if (position == size) {
      addAtTail(value);

    } else {
      ListNode p = head;
      for (int i = 0; i < position - 1; i++) {
        p = p.next;
      }
            /*
            Node n = new Node(value);
            n.next = p.next;
            p.next = n;
            */
      ListNode n = new ListNode(value);
      ListNode save = p;
      p = p.next;
      save.next = n;
      n.next = p;
      size++;
    }
  }

  /** Delete the position-th node in the linked list, if the position is valueid. */
  public void deleteAtposition(int position) {
    if (size == 0 || position < 0 || position >= size) {
      return;
    }
    if (position == 0) {
      head = head.next;
      size--;
      if (size == 0) {
        tail = null;
      }
    } else {
      ListNode p = head;
      for (int i = 0; i < position - 1; i++) {
        p = p.next;
      }
      p.next = p.next.next;
      size--;
      if (p.next == null) {
        tail = p;
      }
    }
  }
  public void printList(MyLinkedList list)
  {
    ListNode currNode = list.head;

    System.out.print("LinkedList: ");

    while (currNode != null) {
      System.out.print(currNode.value + " ");
      currNode = currNode.next;
    }

    System.out.println();
  }
  public static void main(String[] args) {
    MyLinkedList obj = new MyLinkedList();
    MyLinkedList list = new MyLinkedList();
    obj.addAtHead(5);
    obj.addAtposition(1,23);
    obj.addAtposition(2,24);
    obj.printList(obj);
    obj.deleteAtposition(1);
    obj.printList(obj);
//    list = insert(list, 1);
//    list = insert(list, 2);
//    list = insert(list, 3);
//    list = insert(list, 4);
//    list = insert(list, 5);
//    list = insert(list, 6);
//    list = insert(list, 7);
//    list = insert(list, 8);

  //  printList(list);
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(position);
 * obj.addAtHead(value);
 * obj.addAtTail(value);
 * obj.addAtposition(position,value);
 * obj.deleteAtposition(position);
 */