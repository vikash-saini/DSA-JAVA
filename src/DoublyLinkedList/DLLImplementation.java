package DoublyLinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int d, Node next1, Node prev1){
        this.data = d;
        this.next = next1;
        this.prev = prev1;
    }

    public Node(int d){
        this.data = d;
        this.next = null;
        this.prev = null;
    }
}
public class DLLImplementation {
    public Node covertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        
        return head;
    }

    static void display(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.err.println();
    }

    static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = head;
        head = head.next;

        head.prev = null;
        prev.next = null;
        return head;
    }

    static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;

        while(tail.next != null){
            Node temp = tail.next;
            tail = temp;
            tail.next = temp.next;
        }
        Node newTail = tail.prev;
        tail.prev = null;
        newTail.next = null;
        return head;
    }

    static Node removeKthElement(Node head, int k) {
        if (head == null) return null;
        Node kthNode = head;
        int count = 0;
        while(kthNode != null) {
            count++;
            if (count == k) break;
            Node temp = kthNode.next;
            kthNode = temp;
        }
        Node prev = kthNode.prev;
        Node front = kthNode.next;
        if (prev == null && front == null) return null;
        else if (prev == null) {
            deleteHead(head);
        } else if (front == null) {
            deleteTail(head);
        }

        kthNode.prev = null;
        kthNode.next = null;
        prev.next = front;
        front.prev = prev;
        return head;
    }

    void deletANode(Node temp) {
        Node prev = temp.prev;
        Node front = temp.next;

        if (front == null) {
            prev.next = null;
            temp.prev = null;
        }
        prev.next = front;
        front.prev = prev;

        temp.prev = null;
        temp.next = null;

    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,4};
        Node head = covertArr2DLL(arr);
        display(head);

        // head = deleteHead(head);
        // display(head);

        // head = deleteTail(head);
        // display(head);

        head = removeKthElement(head,3);
        display(head);
    }
}
