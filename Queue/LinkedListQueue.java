import java.util.*;

class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

class Queue {
    Node front;
    Node rear;
    int length;

    Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public void enqueue(int data) {
        Node temp = new Node(data);
        if (front == null && rear == null) {
            front = temp;
            rear = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
        length++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue UnderFlow!");
            return -1;
        } else {
            int data = front.data;
            front = front.next;
            if (front == null) {
                rear = null; // If the queue becomes empty, reset rear as well
            }
            length--;
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue UnderFlow!");
            return -1;
        } else {
            return front.data;
        }
    }

    public boolean isEmpty() {
        if (front == null && rear == null)
            return true;
        else
            return false;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class LinkedListQueue {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Queue: ");
        q.display(); // Output: 10 20 30 40 50

        System.out.println("Dequeued: " + q.dequeue()); // Output: 10
        System.out.println("Queue: ");
        q.display(); // Output: 20 30 40 50

        System.out.println("Peek: " + q.peek()); // Output: 20
        System.out.println("Size: " + q.length); // Output: 4
    }
}
