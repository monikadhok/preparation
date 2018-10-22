package oata.basics;

public class LinkedList{

    public class Node { 
        int data;
        Node next;

        Node(int value){
            data = value;
            next = null;
        }
    }

    Node head;

    //push
    public void push(int value){
        Node node = new Node(value);
        if(this.head == null){
            this.head = node;
        } else {
            Node tmp = this.head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    //insertAtHead
    public void insertAtHead(int value){
        Node node = new Node(value);
        Node tmp = this.head;
        if(tmp == null){
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void deleteAt(int idx){
        int counter = 0;
        Node prev = null;
        Node curr = this.head;
        while(curr != null){
            if(counter == idx){
                System.out.println("Found the counter " + counter);
                if(prev == null){
                    this.head = curr.next;
                    break;
                } else {
                    prev.next = curr.next;
                    break;
                }
            }
            prev = curr;
           curr = curr.next;
           counter++;
        }
    }
    //Reverse TODO
    public void reverse(){
        Node prev = null, next = null;
        Node curr = this.head;

        while(curr != null){
          // store next node
        next = curr.next;
        // Now change next of current
        // This is where actual reversing happens
        curr.next = prev;

        // Move prev and curr one step forward
        prev = curr;
        curr = next;
        }
        this.head = prev;
    }

    //Reverse in batches?

    public void print(){
        Node tmp = this.head;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args){
        System.out.println("Hello world!");

        LinkedList ll = new LinkedList();
        ll.push(1);
        ll.push(5);
        ll.push(3);
        ll.push(7);
        ll.push(8);

        System.out.println("Printing linked list:");
        ll.print();

        ll.insertAtHead(0);
        ll.insertAtHead(-1);

        System.out.println("Printing linked list:");
        ll.print();

        ll.deleteAt(0);
        ll.deleteAt(2);

        System.out.println("Printing linked list:");
        ll.print();

        ll.reverse();
        System.out.println("Printing linked list:");
        ll.print();     

    }
}