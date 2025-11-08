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

public class ArrayToLinkedlist {

    static Node convertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++) {
           Node temp = new Node(arr[i]);
           mover.next = temp;
           mover = temp;
        } 
        return head;
    }
    
    static int length(Node list){
        int count = 0;
        Node temp = list;
        // Node list = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
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

    static boolean checkIfPresent(Node list, int num){
        Node temp = list;
        while (temp != null) {
            if (temp.data == num) return true;
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {3,6,7,9,15};
        Node head = convertArr2LL(arr);
        // size
        System.out.println("Size of LL: "+ length(head));
        // Print List
        display(head);

        // Check if Present
            int target = 10;
         System.out.println(target+" present in LL: "+ checkIfPresent(head,target));
        
    }
}
