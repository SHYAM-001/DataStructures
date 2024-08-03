import java.util.*;

class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

class Stack {
    private Node top;

    // Constructor to initialize stack
    public Stack() {
        top = null;
    }

    // Push operation
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // Pop operation
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    // Peek operation
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return top.data;
        }
    }

    // isEmpty operation
    public boolean isEmpty() {
        return (top == null);
    }

    // Display the stack
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); // Output: 30 20 10
        System.out.println(stack.pop()); // Output: 30
        stack.display(); // Output: 20 10
        System.out.println(stack.peek()); // Output: 20
        System.out.println(stack.isEmpty()); // Output: false
    }
}