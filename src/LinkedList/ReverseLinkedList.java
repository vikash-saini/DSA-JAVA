package LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ArrayToLinkedlist ll = new ArrayToLinkedlist();
        int[] arr = {3,6,7,9,15};
        Node head = ll.convertArr2LL(arr);
        ll.display(head);
        // Node head1 = reverse(head);
        // ll.display(head1);

        Node reverseNode = reverseWitRecursion(head);
        ll.display(reverseNode);
    }

    // TC : O(N) , SC:(1)
    static Node reverse(Node head) {
        Node temp  = head;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    
    static Node reverseWitRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newNode  = reverseWitRecursion(head.next);
        Node frontNode = head.next;
        frontNode.next = head;
        head.next = null;
        return newNode;
    }
}
