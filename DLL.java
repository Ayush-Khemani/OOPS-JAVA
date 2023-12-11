package CoustomLinkedList;

public class DLL {
    private Node Head;
    private Node Tail;
    private int size;

    

    public DLL() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }
    

    

    public void InsertFirst(int data) {
        Node temp = new Node(data); // Node to be added
        temp.next = Head;
        temp.prev = null;
        if (Head!=null) {   
            Head.prev = temp;    
        }
        Head = temp;

        if (Tail == null) { // This is the first element being inserted.
            Tail = Head;
        } 

        this.size++;

    }

    public void InsertLast(int data) {
        if (Head == null) { // This is the first element being inserted.
            InsertFirst(data);
            return;
        }

        Node temp = new Node(data); // Node to be added.
        Tail.next = temp;
        temp.prev = Tail;
        Tail = temp;

        this.size++; // Increase the size

    }

    public void InsertAt(int data, int pos) {
        Node node = new Node(data); // Node to be added.
        Node temp = Head; // Node to be traversed.
        for (int i =0; i<pos-1; i++) {
            temp = temp.next;
        }

        node.next = temp.next;
        node.prev = temp;
        node.next.prev = node;
        temp.next = node;


        this.size++; // Increase the size.

    }

    public int RemoveFirst() {
        int val = Head.data;
        Head = Head.next;
        Head.prev = null;

        this.size--;

        return val;
    }

    public int RemoveLast() {
        int val = Tail.data;
        Tail = Tail.prev;
        Tail.next = null;

        this.size--;

        return val;

    }

    public int RemoveAt(int pos) {
        if (pos == 0) { // We are asked to remove the very first element.
            return RemoveFirst();
        }
        if (pos == size - 1) { // We are asked to remove the last element.
            return RemoveLast();
        }

        Node temp = Head;
        for (int i =0; i<pos-1; i++)
        {
            temp = temp.next;
        }

        int val = temp.next.data;
        temp.next = temp.next.next;
        temp.next.prev = temp;

        this.size--;

        return val;
    }


    public void display() {
        Node temp = Head; // NOde to be traversed
        while(temp!=null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("End");
        System.out.println();
    }
    

    public void ReverseDisplay() {
        Node temp = Tail; // Used for the traversal backwards.
        System.out.print("End");
        while(temp!=null) {
            System.out.print(" <-" + temp.data);
            temp = temp.prev;
        }
        System.out.println();
    }





    class Node {
        int data;
        Node next;
        Node prev;


        public Node(int data) {
            this.data = data;
        }
        
    }
}
