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
        this.data = d;
        this.next = pointer;
    }

}

public class InsertionOnLinkedList {
    static Node convertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }
    static void display(Node list){
        // Traverse though List
        Node temp = list;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    static Node insertHead(Node head, int k){
        return new Node(k,head);
    }
    static Node insertTail(Node head, int k){
        if (head == null) new Node(k);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(k);
        return head;
    }

    static Node insertPosition(Node head, int k, int pos){
        if (head == null) {
            if (pos == 1) {
               return new Node(k);
            }else {
                return head;
            }
        }
        if (pos == 1) {
            Node newHead = new Node(k, head);
            return newHead;
        }
        int count = 0; Node temp = head;
        while (temp!= null) {
            count++;
            if (count == (pos-1)) {
                Node x = new Node(k, temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next; 
        }
        return head;
    }
    static Node insertBeforeValue(Node head, int ele, int val){
        if (head == null) return null;
        if (head.data == val) {
            Node newHead = new Node(ele, head);
            return newHead;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                Node x = new Node(ele, temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next; 
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {12,5,8,9};
        Node head = convertArr2LL(arr);
        display(head); // before
        head = insertHead(head, 3); //insert head
        display(head);
        head = insertTail(head,7); //insert tail
        display(head);
        head = insertPosition(head,100,3); //insert at position
        display(head);
        head = insertBeforeValue(head,14,9); //insert before value
        display(head);
    }
}
