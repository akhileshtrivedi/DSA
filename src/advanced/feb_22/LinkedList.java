package advanced.feb_22;


public class LinkedList {

    class Node {
      int val;
      Node next;
      public Node(int val) {
        this.val = val;
      }
    }

    private Node head;
    private Node tail;
    private int size;

    /** Initialize your data structure here. */
    public LinkedList() {
      head = null;
      tail = null;
      size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
      if (index >= size) {
        return -1;
      }
      LinkedList.Node p = head;
      for (int i = 0; i < index; i++) {
        p = p.next;
      }
      return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
      LinkedList.Node n = new LinkedList.Node(val);
      n.next = head;
      head = n;
      size++;

      if (head.next == null) {
        tail = head;
      }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
      LinkedList.Node n = new LinkedList.Node(val);
      if (tail != null) {
        tail.next = n;
      }
      if (tail == null || size == 0) {
        head = n;
      }
      tail = n;
      size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
      if (index < 0 || index > size) {
        return;
      }
      if (index == 0) {
        addAtHead(val);

      } else if (index == size) {
        addAtTail(val);

      } else {
        LinkedList.Node p = head;
        for (int i = 0; i < index - 1; i++) {
          p = p.next;
        }
            /*
            Node n = new Node(val);
            n.next = p.next;
            p.next = n;
            */
        LinkedList.Node n = new LinkedList.Node(val);
        LinkedList.Node save = p;
        p = p.next;
        save.next = n;
        n.next = p;
        size++;
      }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
      if (size == 0 || index < 0 || index >= size) {
        return;
      }
      if (index == 0) {
        head = head.next;
        size--;
        if (size == 0) {
          tail = null;
        }
      } else {
        LinkedList.Node p = head;
        for (int i = 0; i < index - 1; i++) {
          p = p.next;
        }
        p.next = p.next.next;
        size--;
        if (p.next == null) {
          tail = p;
        }
      }
    }
    public void printList(LinkedList list)
    {
      LinkedList.Node currNode = list.head;

      System.out.print("LinkedList: ");

      while (currNode != null) {
        System.out.print(currNode.val + " ");
        currNode = currNode.next;
      }

      System.out.println();
    }
    public static void main(String[] args) {
      LinkedList obj = new LinkedList();
      LinkedList list = new LinkedList();
      obj.addAtHead(5);
      obj.addAtIndex(1,23);
      obj.addAtIndex(2,24);
      obj.printList(obj);
      obj.deleteAtIndex(1);
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
  /*
  Node head;
  static class Node {

    int data;
    Node next;

    Node(int d)
    {
      data = d;
      next = null;
    }
  }

  public static LinkedList insert(LinkedList list,
      int data)
  {
    Node new_node = new Node(data);
    new_node.next = null;

    if (list.head == null) {
      list.head = new_node;
    }
    else {

      Node last = list.head;
      while (last.next != null) {
        last = last.next;
      }

      last.next = new_node;
    }

    return list;
  }

  public static void printList(LinkedList list)
  {
    Node currNode = list.head;

    System.out.print("LinkedList: ");

    while (currNode != null) {
      System.out.print(currNode.data + " ");
      currNode = currNode.next;
    }

    System.out.println();
  }
  public static LinkedList
  deleteAtPosition(LinkedList list, int position)
  {
    Node currNode = list.head, prev = null;

    if (position == 0 && currNode != null) {
      list.head = currNode.next;
      return list;
    }
    int counter = 0;
    while (currNode != null) {

      if (counter == position) {
        prev.next = currNode.next;
        break;
      }
      else {
        prev = currNode;
        currNode = currNode.next;
        counter++;
      }
    }

    if (currNode == null) {

    }

    return list;
  }

  public static void main(String[] args)
  {
    /* Start with the empty list. */
  /*  LinkedList list = new LinkedList();

    list = insert(list, 1);
    list = insert(list, 2);
    list = insert(list, 3);
    list = insert(list, 4);
    list = insert(list, 5);
    list = insert(list, 6);
    list = insert(list, 7);
    list = insert(list, 8);

    printList(list);

    deleteAtPosition(list, 0);

    printList(list);

    deleteAtPosition(list, 2);

    printList(list);

    deleteAtPosition(list, 10);

    printList(list);
  }
}






/*public class LinkedList {

  Node head;

  static class Node {

    int data;
    Node next;
    Node(int d)
    {
      data = d;
      next = null;
    }
  }

  public static LinkedList insert(LinkedList list, int data)
  {
    Node new_node = new Node(data);
    if (list.head == null) {
      list.head = new_node;
    }
    else {
      Node last = list.head;
      while (last.next != null) {
        last = last.next;
      }
      last.next = new_node;
    }
    return list;
  }

  public static void printList(LinkedList list)
  {
    Node currNode = list.head;
    System.out.println("LinkedList: ");

    while (currNode != null) {
      System.out.println(currNode.data + " ");
      currNode = currNode.next;
    }
  }

  // Driver code
  public static void main(String[] args)
  {

    LinkedList list = new LinkedList();

    list = insert(list, 1);
    list = insert(list, 2);
    list = insert(list, 3);
    list = insert(list, 4);
    list = insert(list, 5);
    list = insert(list, 6);
    list = insert(list, 7);
    list = insert(list, 8);

    printList(list);


  }
}*/