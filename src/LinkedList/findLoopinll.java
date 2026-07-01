package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class findLoopinll {
     
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // create loop: 5 -> 3
        fifth.next = third;
        // display(head);
        System.out.println(isloopexists(head));
        System.out.println("Optimized Approach: "+isloopExistsOpt(head)); 
    }

    static boolean isloopexists(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node temp = head;
        Map<Node,Integer> map = new HashMap<>();
        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return false;
    }

    // Optimized Approach
    static boolean isloopExistsOpt(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slowNode = head;
        Node fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
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
}