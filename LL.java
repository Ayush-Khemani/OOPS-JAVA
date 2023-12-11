package CoustomLinkedList;

public class LL {

    private Node Head;
    private Node Tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {

        return Head;
    }

    public void insertFirst(int data) {

        Node tmp = new Node(data);
        tmp.next = Head;
        Head = tmp;

        if (Tail == null)
        {
            Tail = Head;
        }

        size++;
    }

    public void insertLast(int data) {

        if (Head == null) // This is the first element being inserted
        {
            insertFirst(data);
            return;
        }

        Node tmp = new Node(data);
        Tail.next = tmp;
        Tail = tmp;

        size++;
    }

    public void InsertRec(int data, int pos) {

        if (pos == 0) {
            insertFirst(data);
            return;
        }
        if (pos == size - 1) {
            insertLast(data);
            return;
        }

        Node node = Head;
        InsertRec2(data, pos-1, node);
        this.size++;
    }



    private void InsertRec2(int data, int pos, Node node) {

        if (pos == 0) {
            Node temp = new Node(data, node.next);
            node.next = temp;
            return;
        }

        InsertRec2(data, pos-1, node.next);
        
    }

    public void RemoveDup(Node node) {
        Node temp = Head;

        while(temp.next!=null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            }
            else
            {
                temp = temp.next;
            }
        }

    }

    public Node FindMid() {

        Node fast = Head;
        Node slow = Head;

        while(fast!=null & fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }




    public void ReverseList(Node temp) {

        if (temp == Tail) {
            Head = Tail;
            return;
        }


        ReverseList(temp.next);

        Tail.next = temp;
        Tail = temp;
        Tail.next = null;
    }

    // Merge two sorted lists.
    public LL MergeLists(LL List1, LL List2) {
        // Create a ans link list.
        LL ans = new LL();
        Node temp1 = List1.Head;
        Node temp2 = List2.Head;

        while(temp1!= null || temp2!= null) {
            if (temp1 == null && temp2!= null) {
                ans.Tail.next = temp2;
                return ans;
            }
            if (temp2 == null && temp1!=null) {
                ans.Tail.next = temp1;
                return ans;
            }
            if (temp1.data < temp2.data) {
                ans.insertLast(temp1.data);
                temp1 = temp1.next;
            }
            else if (temp2.data < temp1.data) {
                ans.insertLast(temp2.data);
                temp2 = temp2.next;
            }
            else {  // In case both are equal we take any one of them.
                ans.insertLast(temp1.data);
                temp1 = temp1.next;
            }
        }

        return ans;

    }

    public void insertAt(int data, int pos) {
        Node node = new Node(data); // Node to be added.
        Node temp = Head; // Node used for traversal.

        for (int i=0; i<pos-1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++; // Increase the size

    }


    public int removeFirst() {
        int val = Head.data;
        Head = Head.next;
        size--;

        return val;
    }

    public void removeLast() {
        Node temp = Head; // Node to be traversed.
        while(temp.next!=Tail) {
            temp = temp.next;
        }
        temp.next = null;
        Tail = temp;
        size--; // Decrease the size.
    }

    public void display() {
        Node tmp = Head;
        while(tmp!=null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.print("End");
    }

    public LL PartitionList(int val) {
        LL lessthanX = new LL();
        LL moreThanX = new LL();

        Node temp = Head;
        Node X = getNode(Head, val);

        while(temp!=null) {
            if (temp.data < X.data) {
                lessthanX.insertLast(temp.data);
            }
            else {
                moreThanX.insertLast(temp.data);
            }
            temp = temp.next;
        }

        lessthanX.Tail.next = moreThanX.Head;

        return lessthanX;
    }

    public Node getNode(Node temp, int x) {

        while(temp.data!=x) {
            temp = temp.next;
        }
        return temp;
    }

    public LL Sort012() {
    
        int zerocnt = 0;
        int onecnt = 0;
        int twocnt = 0;

        Node temp = Head;
        while(temp!=null) {
            if (temp.data == 2) {
                twocnt++;
            }
            else if (temp.data == 1) {
                onecnt++;
            }
            else {
                zerocnt++;
            }

            temp = temp.next;
        }

        LL ans = new LL();
        for (int i =0; i<zerocnt; i++) {
            ans.insertLast(0);
        }
        for (int i =0; i<onecnt; i++) {
            ans.insertLast(1);
        }
        for (int i =0; i<twocnt; i++) {
            ans.insertLast(2);
        }

        return ans;


    }


    class Node {
        int data;
        Node next;


        public Node(int data) {
            this.data = data;
        }


        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        
    }

}
