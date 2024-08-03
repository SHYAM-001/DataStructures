import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}

class doublelinked {
    Node head;
    Node tail;
    int length;

    doublelinked() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    void insertBeg(int data) {
        Node temp = new Node(data);
        if (head == null && tail == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        length++;
    }

    void insertEnd(int data) {
        Node temp = new Node(data);
        if (head == null && tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        length++;
    }

    void insertMid(int data, int pos) {
        if (pos <= 1) {
            insertBeg(data);
        } else if (pos > length) {
            insertEnd(data);
        } else {
            Node temp = new Node(data);
            Node temp1 = head;
            int n = 1;
            while (n < pos - 1) {
                temp1 = temp1.next;
                n++;
            }
            temp.next = temp1.next;
            temp1.next = temp;
            temp.prev = temp1;
            if (temp.next != null) {
                temp.next.prev = temp;
            } else {
                tail = temp;
            }
        }
        length++;
    }

    void deleteBeg() {
        if (head == null) {
            return;
        } else {
            head = head.next;
            head.prev = null;
            length--;
        }
    }

    void deleteEnd() {
        if (head == null && tail == null) {
            return;
        } else {
            tail = tail.prev;
            tail.next = null;
            length--;
        }
    }

    void deleteMid(int pos) {
        if (pos <= 1) {
            deleteBeg();
        } else if (pos > length) {
            deleteEnd();
        } else {
            Node temp = head;
            int n = 1;
            while (n < pos - 1) {
                temp = temp.next;
                n++;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
                if (temp.next != null) {
                    temp.next.prev = temp;
                } else {
                    tail = temp;
                }
                length--;
            }
        }
    }

    void reverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
    }

}

public class DoubleLinkedList {
    public static void main(String[] args) {
        doublelinked d = new doublelinked();
        d.insertEnd(50);
        d.insertEnd(70);
        d.insertEnd(80);
        d.insertBeg(40);
        d.insertBeg(20);
        d.insertMid(60, 4);
        d.display();
        System.out.println();
        d.deleteMid(3);
        d.display();
        System.out.println();
        d.reverse();
    }
}