public class LinkedListExample {

    public static class Node {
        Object element;
        Node next;

        public Node(Object element, Node prevNode) {
            this.element = element;
            prevNode = this;
        }

        public Node(Object element) {
            this.element = element;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public LinkedListExample() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public Node add(Node head, int data, int position) {
        Node newNode = new Node(head);
        newNode.element = data;
        newNode.next = null;

        if (head == null) {
            return newNode;
        }
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node prev = null;
        Node current = head;
        int i = 0;
        while (current != null && i < position) {
            prev = current;
            current = current.next;
            i++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;

    }

    public void delete(Node previous) {
        if (previous.next == tail) {
            tail = previous;
            tail.next = null;
        } else {
            if (previous == tail) {
                return;
            } else {
                previous.next = previous.next.next;
            }
        }
    }



    public int getSize() {
        return count;
    }


    public void printToDisplay(Node head) {
        if (head == null) {
            return;
        }
        Node currectNode = head;

        while (currectNode != null) {

            System.out.print(currectNode.element + " ---> ");
            currectNode = currectNode.next;
            count++;
        }
        System.out.println(currectNode);
    }



    public static void main(String[] args) {
        Node head = new Node(01);
        Node second = new Node(02);
        Node third = new Node(03);
        Node forth = new Node(04);

        head.next = second;
        second.next = third;
        third.next = forth;

        LinkedListExample list = new LinkedListExample();
        System.out.print("Linked List: ");
        list.printToDisplay(head);

        System.out.println("Size of list is: " + list.getSize());

        System.out.print("Linked List with add element: ");
        list.add(head,05,5);
        list.printToDisplay(head);


        System.out.print("Linked List with deleted element: ");
        list.delete(second);
        list.printToDisplay(head);


    }
}
