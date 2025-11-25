package LinkedList;

class Node{
    int data;
    Node next;
    // Constructor for Intialization
    Node(int d){
        this.data = d;
        this.next = null;
    }

    Node(int d,Node pointer){
        data = d;
        next = pointer;
    }

}

public class DeletionOnLinkedList {
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
    static Node removeHead(Node head){
        if (head == null) return null;
        head = head.next;
        return head;
    }
    
    static Node removeTail(Node head){
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    static Node removeK(Node head, int k){
        if (head == null || head.next == null) return head;
        if (k == 1) {
            head = head.next;
            return head;
        }
        Node prev = null;
        int count =0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    static Node removeEle(Node head, int ele){
        if (head == null || head.next == null) return head;
        if (head.data == ele) {
            head = head.next;
            return head;
        }
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            if (temp.data == ele) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        int[] arr = {12,5,8,9};
        Node head = convertArr2LL(arr);
        display(head); // before
        // head = removeHead(head); //delete head
        // display(head);
        // head = removeTail(head); //delete tail
        // display(head);
        // head = removeK(head,2); //delete tail
        // display(head);
        head = removeEle(head,12); //delete element
        display(head);
    }
}
