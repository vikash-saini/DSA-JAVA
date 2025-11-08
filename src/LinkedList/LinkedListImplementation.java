package LinkedList;

class Node{
    int data;
    Node next;
    // Constructor for Intialization
    Node(int d){
        data = d;
        next = null;
    }

    Node(int d,Node pointer){
        data = d;
        next = pointer;
    }
}
public class LinkedListImplementation {
    public static void main(String[] args) {
        int[] arr = {3,6,7,9,15};
        Node x = new Node(arr[1]);
        System.out.print(x.data+", ");
        System.out.println(x.next);

        Node y = new Node(4,null);
        System.out.print(y.data+", ");
        System.out.println(y.next);
    }
}
