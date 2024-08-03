
Certainly! Here's a detailed explanation of each data structure topic using Markdown. I'll include Mermaid diagrams where applicable to visually represent the concepts.

---

# Data Structures Overview

## What is Data Structure?

A **data structure** is a specialized format for organizing and storing data. It provides a way to manage data efficiently and is fundamental to designing efficient algorithms. Data structures can be classified based on their type, purpose, and operations. 

**Types:**
- **Linear Data Structures**: Arrays, Linked Lists, Stacks, Queues
- **Non-linear Data Structures**: Trees, Graphs
- **Hash-based Structures**: Hash Tables
- **Advanced Data Structures**: Heaps, Tries, Segment Trees, Suffix Trees

**Applications:**
- **Arrays**: Useful for storing and accessing elements in a fixed-size collection.
- **Linked Lists**: Efficient for dynamic memory allocation and frequent insertions/deletions.
- **Stacks and Queues**: Ideal for scenarios requiring Last-In-First-Out (LIFO) or First-In-First-Out (FIFO) operations.
- **Trees and Graphs**: Suitable for hierarchical and networked data representation.
- **Hashing**: Provides fast data retrieval based on key values.

## Classification of Data Structures

1. **Primitive Data Structures**: Integer, Float, Character, etc.
2. **Non-Primitive Data Structures**: Arrays, Lists, Stacks, Queues, Trees, Graphs
   - **Linear Data Structures**: Arrays, Linked Lists, Stacks, Queues
   - **Non-Linear Data Structures**: Trees, Graphs
   - **Hash-Based Structures**: Hash Tables
   - **Advanced Data Structures**: Heaps, Tries, Segment Trees, Suffix Trees

## Introduction to Data Structures

Data structures are used to manage and organize data to perform operations efficiently. They can be classified into:

- **Arrays**: Fixed-size, indexed collection of elements.
- **Linked Lists**: Nodes linked sequentially.
- **Stacks**: Collection of elements with LIFO order.
- **Queues**: Collection of elements with FIFO order.
- **Trees**: Hierarchical structures with nodes.
- **Graphs**: Network of nodes and edges.

**Common Operations:**
- **Insertion**: Adding data.
- **Deletion**: Removing data.
- **Search**: Finding data.
- **Traversal**: Visiting all elements.

---

## Array Data Structure

### Basic Operations

- **Search, Insert, and Delete in an Unsorted Array**
  - **Search**: Linear search.
  - **Insert**: Append at the end.
  - **Delete**: Remove the element and shift others.

- **Search, Insert, and Delete in a Sorted Array**
  - **Search**: Binary search.
  - **Insert**: Find the position and shift elements.
  - **Delete**: Remove the element and shift others.

### Array Manipulations

- **Reverse an Array**
  ```cpp
  void reverseArray(int arr[], int size) {
      int start = 0, end = size - 1;
      while (start < end) {
          std::swap(arr[start], arr[end]);
          start++;
          end--;
      }
  }
  ```

- **Find Leaders in an Array**
  ```cpp
  void printLeaders(int arr[], int size) {
      int max_from_right = arr[size - 1];
      std::cout << max_from_right << " ";
      for (int i = size - 2; i >= 0; i--) {
          if (arr[i] > max_from_right) {
              max_from_right = arr[i];
              std::cout << max_from_right << " ";
          }
      }
  }
  ```

- **Find Pair with Sum `x`**
  ```cpp
  bool hasPairWithSum(int arr[], int size, int x) {
      std::unordered_set<int> s;
      for (int i = 0; i < size; i++) {
          if (s.find(x - arr[i]) != s.end()) return true;
          s.insert(arr[i]);
      }
      return false;
  }
  ```

### Advanced Problems

- **Median of Two Sorted Arrays**
  ```cpp
  double findMedianSortedArrays(int nums1[], int size1, int nums2[], int size2) {
      std::vector<int> merged(size1 + size2);
      std::merge(nums1, nums1 + size1, nums2, nums2 + size2, merged.begin());
      int mid = merged.size() / 2;
      if (merged.size() % 2 == 0)
          return (merged[mid - 1] + merged[mid]) / 2.0;
      else
          return merged[mid];
  }
  ```

- **Rotate an Array**
  ```cpp
  void rotateArray(int arr[], int size, int d) {
      std::reverse(arr, arr + d);
      std::reverse(arr + d, arr + size);
      std::reverse(arr, arr + size);
  }
  ```

### Visualization

```mermaid
graph TD
    A[Array] --> B[Reverse]
    A --> C[Search]
    A --> D[Insert]
    A --> E[Delete]
    B --> F[Swap elements]
    C --> G[Linear search]
    C --> H[Binary search]
    D --> I[Append at end]
    E --> J[Remove and shift]
```

---

## Linked List Data Structure

### Singly Linked List

- **Introduction to Linked List**
  - **Linked List vs Array**: Dynamic size vs fixed size, ease of insertion/deletion.
- **Insertion and Deletion**
  - **Insertion**: At head, at end, after a given node.
  - **Deletion**: Remove a node with a specific key or at a specific position.

```cpp
struct Node {
    int data;
    Node* next;
};

void insertAtEnd(Node*& head, int data) {
    Node* newNode = new Node{data, nullptr};
    if (!head) {
        head = newNode;
        return;
    }
    Node* temp = head;
    while (temp->next) {
        temp = temp->next;
    }
    temp->next = newNode;
}

void deleteNode(Node*& head, int key) {
    Node* temp = head;
    Node* prev = nullptr;
    if (temp && temp->data == key) {
        head = temp->next;
        delete temp;
        return;
    }
    while (temp && temp->data != key) {
        prev = temp;
        temp = temp->next;
    }
    if (temp) {
        prev->next = temp->next;
        delete temp;
    }
}
```

- **Reverse a Linked List**
  ```cpp
  Node* reverse(Node* head) {
      Node* prev = nullptr;
      Node* current = head;
      Node* next = nullptr;
      while (current) {
          next = current->next;
          current->next = prev;
          prev = current;
          current = next;
      }
      return prev;
  }
  ```

### Circular Linked List

- **Introduction and Applications**
  - **Circular Singly Linked List Insertion**: Node points to the head.
  - **Traversal**: Iteratively traverse until the head is reached again.

### Doubly Linked List

- **Introduction and Insertion**
  - **Doubly Linked List**: Nodes with pointers to both next and previous nodes.
  - **Insertion**: At head, at end, before, and after a given node.

```cpp
struct DoublyNode {
    int data;
    DoublyNode* next;
    DoublyNode* prev;
};

void insertAtHead(DoublyNode*& head, int data) {
    DoublyNode* newNode = new DoublyNode{data, head, nullptr};
    if (head) head->prev = newNode;
    head = newNode;
}
```

### Visualization

```mermaid
graph TD
    A[Singly Linked List] --> B[Head]
    A --> C[Insert]
    A --> D[Delete]
    A --> E[Reverse]
    B --> F[Node]
    C --> G[At Head]
    C --> H[At End]
    D --> I[Specific Key]
    E --> J[Iterative]
```

---

## Matrix Data Structure

- **Search in Row-wise and Column-wise Sorted Matrix**
  ```cpp
  bool searchMatrix(int matrix[][], int rows, int cols, int target) {
      int i = 0, j = cols - 1;
      while (i < rows && j >= 0) {
          if (matrix[i][j] == target) return true;
          if (matrix[i][j] > target) j--;
          else i++;
      }
      return false;
  }
  ```

- **Print Matrix in Spiral Form**
  ```cpp
  void printSpiral(int matrix[][], int rows, int cols) {
      int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
      while (top <= bottom && left <= right) {
          for (int i = left; i <= right; i++) std::cout << matrix[top][i] << " ";
          top++;
          for (int i = top; i <= bottom; i++) std::cout << matrix[i][right] << " ";
          right--;
          if (top <= bottom) {
              for (int i = right; i >= left; i--) std::cout << matrix[bottom][i] << " ";
              bottom--;


          }
          if (left <= right) {
              for (int i = bottom; i >= top; i--) std::cout << matrix[i][left] << " ";
              left++;
          }
      }
  }
  ```

### Visualization

```mermaid
graph TD
    A[Matrix] --> B[Search]
    A --> C[Print Spiral]
    B --> D[Row-wise & Column-wise Sorted]
    C --> E[Top-Right-Bottom-Left]
```

---

## Stack Data Structure

- **Introduction to Stack**
  - **LIFO Order**: Last-In-First-Out.
- **Common Operations**
  - **Push**: Add an element.
  - **Pop**: Remove the top element.
  - **Peek**: View the top element.

```cpp
class Stack {
    std::stack<int> s;
public:
    void push(int x) { s.push(x); }
    void pop() { if (!s.empty()) s.pop(); }
    int top() { return s.top(); }
};
```

- **Infix to Postfix Conversion**
  ```cpp
  std::string infixToPostfix(const std::string& infix) {
      std::stack<char> s;
      std::string postfix;
      for (char c : infix) {
          if (isalnum(c)) postfix += c;
          else if (c == '(') s.push(c);
          else if (c == ')') {
              while (!s.empty() && s.top() != '(') {
                  postfix += s.top();
                  s.pop();
              }
              s.pop();
          } else {
              while (!s.empty() && precedence(c) <= precedence(s.top())) {
                  postfix += s.top();
                  s.pop();
              }
              s.push(c);
          }
      }
      while (!s.empty()) {
          postfix += s.top();
          s.pop();
      }
      return postfix;
  }
  ```

### Visualization

```mermaid
graph TD
    A[Stack] --> B[Push]
    A --> C[Pop]
    A --> D[Peek]
    B --> E[Add Element]
    C --> F[Remove Top]
    D --> G[View Top]
```

---

## Queue Data Structure

- **Introduction and Array Implementation**
  - **FIFO Order**: First-In-First-Out.
  - **Circular Queue**: Array-based circular implementation.

```cpp
class Queue {
    int front, rear, size;
    int* queue;
public:
    Queue(int capacity) : front(0), rear(-1), size(0) {
        queue = new int[capacity];
    }
    void enqueue(int x) { /* Implementation */ }
    void dequeue() { /* Implementation */ }
};
```

- **Priority Queue**
  - **Heap-based**: Elements with highest priority are dequeued first.

### Visualization

```mermaid
graph TD
    A[Queue] --> B[Enqueue]
    A --> C[Dequeue]
    B --> D[Add Element]
    C --> E[Remove Element]
```

---

## Binary Tree Data Structure

- **Introduction and Properties**
  - **Binary Tree**: Each node has at most two children.
  - **Properties**: Depth, height, and balance.

- **Tree Traversals**
  - **Inorder**: Left-Root-Right.
  - **Preorder**: Root-Left-Right.
  - **Postorder**: Left-Right-Root.
  - **Level Order**: Breadth-First.

```mermaid
graph TD
    A[Binary Tree] --> B[Traversal]
    B --> C[Inorder]
    B --> D[Preorder]
    B --> E[Postorder]
    B --> F[Level Order]
```

---

## Binary Search Tree Data Structure

- **Search and Insert in BST**
  - **Search**: Traverse left for smaller values, right for larger.
  - **Insert**: Insert in the appropriate subtree based on the value.

```cpp
class BST {
    TreeNode* root;
public:
    void insert(int value) { /* Implementation */ }
    TreeNode* search(int value) { /* Implementation */ }
};
```

- **Deletion from BST**
  - **Case 1**: Node has no children.
  - **Case 2**: Node has one child.
  - **Case 3**: Node has two children.

### Visualization

```mermaid
graph TD
    A[BST] --> B[Search]
    A --> C[Insert]
    A --> D[Delete]
    B --> E[Left or Right]
    C --> F[Insert in Subtree]
    D --> G[Handle Cases]
```

---

## Heap Data Structure

- **Binary Heap**
  - **Min-Heap**: Root is the minimum element.
  - **Max-Heap**: Root is the maximum element.
- **Heap Sort**: Sorting algorithm using heaps.

### Visualization

```mermaid
graph TD
    A[Heap] --> B[Min-Heap]
    A --> C[Max-Heap]
    A --> D[Heap Sort]
    B --> E[Root is Minimum]
    C --> F[Root is Maximum]
    D --> G[Sorting Algorithm]
```

---

## Hashing Data Structure

- **Hashing Introduction**
  - **Hash Table**: Data structure for fast retrieval using keys.
- **Collision Handling**
  - **Separate Chaining**: Use linked lists for collisions.
  - **Open Addressing**: Find another slot using probing.

### Visualization

```mermaid
graph TD
    A[Hashing] --> B[Hash Table]
    B --> C[Separate Chaining]
    B --> D[Open Addressing]
    C --> E[Linked Lists]
    D --> F[Probing]
```

---

## Graph Data Structure

- **Representations**
  - **Adjacency Matrix**: Matrix representation.
  - **Adjacency List**: List of edges for each vertex.

- **Traversals**
  - **Breadth-First Search (BFS)**
  - **Depth-First Search (DFS)**

### Visualization

```mermaid
graph TD
    A[Graph] --> B[Adjacency Matrix]
    A --> C[Adjacency List]
    A --> D[BFS]
    A --> E[DFS]
```

---

## Advanced Data Structure

### Advanced Lists

- **Memory Efficient Doubly Linked List**
  - **XOR Linked List**: Nodes store XOR of addresses.

### Segment Tree

- **Segment Tree Basics**
  - **Range Queries**: Sum, minimum, maximum.
  - **Lazy Propagation**: Efficient updates.

### Trie Data Structure

- **Trie Operations**
  - **Insert**: Add words.
  - **Search**: Find words.

### Binary Indexed Tree (Fenwick Tree)

- **Range Queries and Updates**
  - **Point Queries**: Efficient querying.

### Suffix Array and Suffix Tree

- **Suffix Array**: Sorting of suffixes.
- **Suffix Tree**: Efficient substring searches.

### AVL Tree

- **Balanced BST**
  - **Insertion and Deletion**: Maintain balance.

### Splay Tree

- **Self-Adjusting BST**
  - **Search and Insert**: Nodes are moved to the root.

### B Tree

- **Balanced Tree**
  - **Insertion and Deletion**: Balanced with multiple children.

### Red-Black Tree

- **Balanced BST**
  - **Insertion and Deletion**: Maintain red-black properties.

### KD Tree

- **Multi-dimensional Tree**
  - **Search and Insert**: Efficient spatial queries.

### Visualization

```mermaid
graph TD
    A[Advanced Data Structures] --> B[Advanced Lists]
    A --> C[Segment Tree]
    A --> D[Trie]
    A --> E[Binary Indexed Tree]
    A --> F[Suffix Array/Tree]
    A --> G[AVL Tree]
    A --> H[Splay Tree]
    A --> I[B Tree]
    A --> J[Red-Black Tree]
    A --> K[KD Tree]
```

---

Feel free to adjust the level of detail or examples according to your needs!