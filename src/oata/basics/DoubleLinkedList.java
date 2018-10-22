package oata.basics;

public class DoubleLinkedList{

    class Node { 
        int data;
        Node next;
        Node prev;

        Node(int value){
            data = value;
            next = null;
            prev = null;
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
            node.prev = tmp;
        }
    }

    //insertAtHead
    public void insertAtHead(int value){
        Node node = new Node(value);
        Node tmp = this.head;
        if(tmp == null){
            this.head = node;
        } else {
            this.head.prev = node;
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
                    this.head.prev = null;
                    break;
                } else {
                    Node tmp = prev;
                    prev.next = curr.next;
                    curr.prev = tmp;
                    break;
                }
            }
            prev = curr;
           curr = curr.next;
           counter++;
        }
    }

    public void reverse(){
        this.head = reverseLocal();
    }

    //Reverse 
    public Node reverseLocal(){
        Node tmp = null;
        Node curr = this.head;

        while(curr != null){
        tmp = curr.prev;
        curr.prev = curr.next;
        curr.next = tmp;

        curr = curr.prev;
    }
    if(tmp != null)
        return tmp.prev;

    return null;
    
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

        DoubleLinkedList ll = new DoubleLinkedList();
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