package intermediate.dec_12;


public class LinkedList {

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
    public static LinkedList deleteByKey(LinkedList list,
                                         int key)
    {
        // Store head node
        Node currNode = list.head, prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head

            // Display the message
            System.out.println(key + " found and deleted");

            // Return the updated List
            return list;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;

            // Display the message
            System.out.println(key + " found and deleted");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }

        // return the List
        return list;
    }
    public static void printList(Node A)
    {
        Node currNode = A;

        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
//6 3 3 6 7 8 7 3 7
        list = insert(list, 6);
        list = insert(list, 3);
        list = insert(list, 3);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
        list = insert(list, 7);
        list = insert(list, 3);
        list = insert(list, 7);
        Node currNode = list.head;
       // printList(list);
        printList(currNode);

        deleteByKey(list, 1);

        // Print the LinkedList
         currNode = list.head;
        // printList(list);
        printList(currNode);

    }
}
