package intermediate.dec_12;

public class CheckSortedLinkedList {


    /* Linked list node */
    static class Node
    {
        int data;
        Node next;
    };

    // function to Check Linked List is
// sorted in descending order or not
    static int isSortedDesc(Node head)
    {
        if (head == null)
            return 0;

        // Traverse the list till last node and return
        // false if a node is smaller than or equal
        // its next.
        // Note just change the condition asc(>) or desc(<)
        for (Node t = head; t.next != null; t = t.next) {
            if (t.data <= t.next.data)
                return 1;
        }
        return 0;
    }

    static Node newNode(int data)
    {
        Node temp = new Node();
        temp.next = null;
        temp.data = data;
        return temp;
    }

    // Driver Code
    public static void main(String[] args)
    {
        Node head = newNode(9);
        head.next = newNode(4);
        head.next.next = newNode(5);
        head.next.next.next = newNode(7);
        /*  Node head = newNode(16);
        head.next = newNode(3);
        head.next.next = newNode(3);
        head.next.next.next = newNode(6);
        head.next.next.next.next = newNode(7);
        head.next.next.next.next.next = newNode(8);
        head.next.next.next.next.next.next = newNode(17);
        head.next.next.next.next.next.next.next = newNode(13);
        head.next.next.next.next.next.next.next.next = newNode(7); */
       // head.next.next.next = newNode(6);

        if(isSortedDesc(head)==1)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

// This code is contributed by 29AjayKumar
