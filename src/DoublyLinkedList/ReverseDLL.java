package DoublyLinkedList;

public class ReverseDLL {
    
    // TC : O(N), SC: 1
    public static Node reversingDll(Node head){
        // we will use swaping mechanism to reverse the dll
        if (head == null || head.next == null) {
            return head;
        }
        Node last = null;
        Node current = head;
        while(current != null) {
            last = current.prev;
            current.prev = current.next;
            current.next = last;
            current = current.prev;
        }
        // current.prev = prev;
        return last.prev;
    }
    public static void main(String[] args) {
        int[] arr = {12,4,5,2,7};
        DLLImplementation dll = new DLLImplementation();
        Node head = dll.covertArr2DLL(arr);
        dll.display(head);
        head = reversingDll(head);
        dll.display(head);
    }
}
