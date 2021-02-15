package lists;
import lists.Node;

public class LinkedList {

    public static void main(String args[]) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        printList(root);
        System.out.println("Inserting a fourth node");
        insert(root, 3, 4);
        printList(root);
        System.out.println("Inserting another node with same value");
        insert(root, 2, 2);
        printList(root);
        System.out.println("Removing the 2 we just added");
        remove(root, 2);
        printList(root);
        System.out.println("Reversing the list");
        root = reverse(root);
        printList(root);
    }
    
    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.val + "->");
            root = root.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void insert(Node head, int index, int val) {
        //create a node at the start of an empty list
        if (head == null) {
            head = new Node(val);
            return;
        }
        
        int i = 1;
        
        //advance past the index
        while (head.next != null && i < index) {
            head = head.next;    
            i++;
        }

        // if the passed index was too big, just append to the end of the list
        if (head.next == null) {
            head.next = new Node(val);
            return;
        }
        
        //create a new node and make the previous node point to it, then
        // make its next pointer point to the next node
        Node temp = head.next;
        head.next = new Node(val);
        head.next.next = temp;
    }

    public static void remove(Node head, int index) {
        if (head == null) {
            return;
        }
        int i = 0;
        Node prev = head;
        while (head.next != null && i < index) {
            prev = head;
            head = head.next;
            i++;
        }
        prev.next = head.next;
    }
    
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        //until we get to the end of the list
        while (curr != null) {
            
            //point the next arrow to the previous node
            Node next = curr.next;
            curr.next = prev;
            
            //advance prev and curr pointers
            prev = curr;
            curr = next;
        }
        return prev;
    }
        
}
