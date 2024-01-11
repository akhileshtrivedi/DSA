package advanced.feb_27;

/* Java program to check if linked list is palindrome */

class PalindromeList {
  ListNode head; // head of list
  ListNode slow_ptr, fast_ptr, second_half;

  /* Linked list Node*/
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x)
    {
      val = x;
      next = null;
    }
  }

  int  isPalindrome(ListNode head)
  {
    slow_ptr = head;
    fast_ptr = head;
    ListNode prev_of_slow_ptr = head;
    ListNode midnode = null;
    int res = 0;
if(head != null && head.next == null){
  return 1;
}

    if (head != null && head.next != null) {
      while (fast_ptr != null
          && fast_ptr.next != null) {
        fast_ptr = fast_ptr.next.next;

        prev_of_slow_ptr = slow_ptr;
        slow_ptr = slow_ptr.next;
      }

      if (fast_ptr != null) {
        midnode = slow_ptr;
        slow_ptr = slow_ptr.next;
      }

      second_half = slow_ptr;
      prev_of_slow_ptr.next
          = null;
      reverse();
      res = compareLists(head,
          second_half);
      reverse();

      if (midnode != null) {
        prev_of_slow_ptr.next = midnode;
        midnode.next = second_half;
      }
      else
        prev_of_slow_ptr.next = second_half;
    }
    return res;
  }

  void reverse()
  {
    ListNode prev = null;
    ListNode current = second_half;
    ListNode next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    second_half = prev;
  }

  int compareLists(ListNode head1, ListNode head2)
  {
    ListNode temp1 = head1;
    ListNode temp2 = head2;

    while (temp1 != null && temp2 != null) {
      if (temp1.val == temp2.val) {
        temp1 = temp1.next;
        temp2 = temp2.next;
      }
      else
        return 0;
    }

    if (temp1 == null && temp2 == null)
      return 1;

    return 0;
  }

  /* Push a node to linked list. Note that this function
  changes the head */
  public void push(int new_data)
  {
		/* Allocate the Node &
		Put in the data */
    ListNode new_node = new ListNode(new_data);

    /* link the old list of the new one */
    new_node.next = head;

    /* Move the head to point to new Node */
    head = new_node;
  }

  // A utility function to print a given linked list
  void printList(ListNode ptr)
  {
    while (ptr != null) {
      System.out.print(ptr.val + "->");
      ptr = ptr.next;
    }
    System.out.println("NULL");
  }

  /* Driver program to test the above functions */
  public static void main(String[] args)
  {

    /* Start with the empty list */
    PalindromeList llist = new PalindromeList();
    PalindromeList llist2 = new PalindromeList();

    //char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
    int[] A={2};
    int[] AA={1, 2, 2, 1,1};
   // String string = new String(str);
    for (int i = 0; i < A.length; i++) {
      llist.push(A[i]);
    }
    for (int i = 0; i < AA.length; i++) {
      llist2.push(AA[i]);
    }
    System.out.println("Is Palindrome  "+llist.isPalindrome(llist.head));
   // System.out.println("Is Palindrome  "+llist2.isPalindrome(llist2.head));
  /*  if (llist.isPalindrome(llist.head) != false) {
      System.out.println("Is Palindrome");
      System.out.println("");
    }
    else {
      System.out.println("Not Palindrome");
      System.out.println("");
    }*/
  }
}
