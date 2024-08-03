import java.util.*;

class Queue {
    int maxSize;
    int[] queue;
    int front;
    int rear;
    int count;

    public Queue(int size) {
        this.maxSize = size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public boolean isEmpty() {
        if (rear == -1 && front == -1)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (rear == maxSize)
            return true;
        else
            return false;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue overflow!");
            return;
        } else {
            rear++;
            queue[rear] = data;
            count++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        } else {
            int data = queue[front];
            front++;
            if (front == maxSize) {
                front = 0;
            }
            count--;
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        } else {
            return queue[front];
        }
    }

    public int size() {
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

public class ArrayQueues {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println("Queue: ");
        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Queue: ");
        q.display();
        System.out.println("Peek: " + q.peek());
        System.out.println("Size: " + q.size());
    }
}
