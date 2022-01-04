package linkedList;


import linkedList.implementation.LinkedList;

public class ReverseLinkedList {
    static Node reverse(Node head) {
        Node currNode = head;
        Node next = null;
        Node prev = null;
        while(currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        return prev; //prev is the new head now
    }

    Node head;

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = null;

        list.head = reverse(list.head);
        //Print reverse list
        print(list.head);
    }

    private static void print(Node head) {
        Node currNode = head;
        while(currNode != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}
