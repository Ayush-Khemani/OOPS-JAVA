package CoustomLinkedList;

public class CLL {
    Node head;
    Node tail;


    public void Insert(int data) {
        Node node = new Node(data);
        if (head == null ) { // This is the first time an element is being inserted.
            head = node;
            tail = node;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void InsertFirst(int data) {
        Node node = new Node(data); // Node to be added.
        if (head == null) {  // This is the3 first time an element is being inserted.
            head = node;
            tail = node;
        }
        node.next = head;
        tail.next = node;
        head = node;


    }

    public void RemoveLast() {
        Node temp = head; // Node to be traversed.
        while(temp.next!=tail) {
           temp = temp.next; 
        }

        temp.next = head;
        tail = temp;

    }

    public void display() {
        Node temp = head; // Node to be traversed.

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp!=head);
        System.out.println("HEAD");
        System.out.println();

    }

    public static Boolean isCyclic(CLL list) {
        Node fast = list.head;
        Node slow = list.head;

        while (true) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
            else if (fast == null || slow == null) {
                return false;
            }
        }

    }

    public static int CylceLen(CLL list) {
        Node fast = list.head;
        Node slow = list.head;
        int len = 0;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                Node temp = slow.next;
                len = 1;

                while(temp.next!=fast) {
                    len++;
                }
            }

        }


        return len;


    }




    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        
    }
    
}
