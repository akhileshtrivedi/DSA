package intermediate.dec_12;


// A complete working Java program to demonstrate all insertion methods
// on linked list
import java.util.Stack;

public class InsertionInLinkedList
{
    Node head; // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public void insertAfter(Node prev_node, int new_data)
    {
        if (prev_node == null)
        {
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void append(int new_data)
    {
        Node new_node = new Node(new_data);
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return;
    }

    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }
    void deleteNode( Node head, int position)
    {
        if (head == null)
            return;

        Node temp = head;

        if (position == 0) {
            head = temp.next; // Change head
            return;
        }

        for (int i = 0; temp != null && i < position - 1;
             i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;

        temp.next = next;
    }

    void printReverse(Node head)
    {
        Stack<Integer> st = new Stack<Integer>();
        Node curr = head;
        while(curr!=null)
        {
            st.push(curr.data);
            curr = curr.next;
        }
        while(st.isEmpty()==false)
        {
            System.out.print(st.peek() + " -> ");
            st.pop();
        }
    }

    public int searchInKthPosition(Node head, int position) {

        Node temp = head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public static void main(String[] args)
    {
        /* Start with the empty list */
        InsertionInLinkedList llist = new InsertionInLinkedList();
        llist.append(6);
        llist.append(3);
        llist.append(3);
        llist.append(6);
        llist.append(7);
        llist.append(8);
        llist.append(7);
        llist.append(3);
        llist.append(7);
        llist.printList();
         System.out.println();
       // llist.insertAfter(llist.head.next.next.next.next, 3);
        System.out.println("Value--->"+llist.searchInKthPosition(llist.head, 1));

         llist.printList();
        System.out.println();

       // llist.printReverse(llist.head);
       // llist.deleteNode(llist.head,6);
       // 6 -> 3 -> 3 -> 6 -> 7 -> 8 -> 7 -> 3 -> 7
       // 6 -> 3 -> 3 -> 6 -> 7 -> 3 -> 8 -> 7 -> 3 -> 7
      //  6      3    3     6   7    3    8    7    3     7
//        llist.printList();
//        System.out.println();
//        // Insert 6. So linked list becomes 6->NUllist
//        llist.append(6);
//        llist.printList();
//        System.out.println();
//        // Insert 7 at the beginning. So linked list becomes
//        // 7->6->NUllist
//        llist.push(7);
//        llist.printList();
//        System.out.println();
//        // Insert 1 at the beginning. So linked list becomes
//        // 1->7->6->NUllist
//        llist.push(1);
//        llist.printList();
//        System.out.println();
//        // Insert 4 at the end. So linked list becomes
//        // 1->7->6->4->NUllist
//        llist.append(4);
//        llist.printList();
//        System.out.println();
//        // Insert 8, after 7. So linked list becomes
//        // 1->7->8->6->4->NUllist
//        llist.insertAfter(llist.head.next, 8);
        llist.printList();
        System.out.println();
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
        System.out.println();
    }
}
// This code is contributed by Rajat Mishra
