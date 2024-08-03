import java.util.*;

class Stack {
    int maxSize;
    int[] stack;
    int top;

    // Constructor to initialize stack
    public Stack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    // TO CHECK ISEMPTY()
    public boolean isEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }

    // TO CHECK ISFULL()
    public boolean isFull() {
        if (top == maxSize - 1)
            return true;
        else
            return false;
    }

    // PUSH OPERATION
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
        } else {
            top++;
            stack[top] = data;
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            top--;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            return stack[top];
        }
        return -1;
    }

}

public class ArrayStack {
    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        System.out.println(Arrays.toString(s.stack));
    }
}
