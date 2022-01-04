package linkedList.implementation;

public class LinkedList {
    Node head;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        insertAtEnd(list, 1);
        insertAtEnd(list, 2);
        insertAtEnd(list, 3);
        insertAtStart(list, 0);
        insertAtStart(list, -1);
        insertAtPosition(list, 5, 6);
        insertAtPosition(list, -2, 1);
        insertAtPosition(list, 4, 7);
        insertAtPosition(list, 4, 10);
        insertAtPosition(list, 4, 0);

        printList(list);
    }

    private static LinkedList insertAtEnd(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = null;
        if(list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    private static LinkedList insertAtPosition(LinkedList list, int data, int position) {
        if(position < 1) {
            System.out.println("Invalid position to insert node. POSITION LESS THAN 1!");
            return list;
        }
        Node newNode = new Node(data);
        boolean isFound = false;
        if(position == 1) {
            newNode.next = list.head;
            list.head = newNode;
        } else {
            Node currNode = list.head;
            while(currNode != null) {
                if(position == 2) {
                    newNode.next = currNode.next;
                    currNode.next = newNode;
                    isFound = true;
                    break;
                }
                currNode = currNode.next;
                position--;
            }
            if(!isFound)
                System.out.println("Invalid position. POSITION GREATER THAN LIST LENGTH!");
        }
        return list;
    }

    private static LinkedList insertAtStart(LinkedList list, int data) {
        Node newNode = new Node(data);
        newNode.next = list.head;
        list.head = newNode;
        return list;
    }

    public static void printList(LinkedList list) {
        Node currNode = list.head;
        System.out.println("Printing linked list...");
        while(currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }
}
