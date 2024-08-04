import java.util.*;

class Tree {
    int data;
    Tree left, right;

    Tree(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}

class binarysearchtrees {
    Tree root;

    binarysearchtrees() {
        this.root = null;
    }

    // Recursive function to delete a node
    public Tree deleteRec(Tree node, int data) {
        if (node == null) {
            return node;
        }

        if (data < node.data) {
            node.left = deleteRec(node.left, data);
        } else if (data > node.data) {
            node.right = deleteRec(node.right, data);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right
            // subtree)
            node.data = minValue(node.right);

            // Delete the inorder successor
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    // Function to find the minimum value in a subtree
    public int minValue(Tree node) {
        int minVal = node.data;
        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }

    // Wrapper function for deleting a node
    public void deleteR(int data) {
        root = deleteRec(root, data);
    }

    // Recursive function to insert a node
    public Tree insertRec(Tree node, int data) {
        if (node == null) {
            node = new Tree(data);
            return node;
        }

        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    // Wrapper function for inserting a node
    public void insertR(int data) {
        root = insertRec(root, data);
    }

    // Recursive function to search for a node
    public boolean searchRec(Tree node, int data) {
        if (node == null) {
            return false;
        }
        if (data == node.data) {
            return true;
        }
        return data < node.data ? searchRec(node.left, data) : searchRec(node.right, data);
    }

    // Wrapper function for searching a node
    public boolean searchR(int data) {
        return searchRec(root, data);
    }

    // Iterative function to search for a node
    public boolean search(int data) {
        Tree current = root;

        while (current != null) {
            if (data == current.data) {
                return true;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    // Iterative function to insert a node
    public void insert(int data) {
        Tree node = new Tree(data);

        if (root == null) {
            root = node;
            return;
        }

        Tree current = root;
        Tree parent = null;

        while (true) {
            parent = current;

            if (data < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = node;
                    return;
                }
            } else if (data > current.data) {
                current = current.right;
                if (current == null) {
                    parent.right = node;
                    return;
                }
            } else {
                return; // Duplicate value, no insertion
            }
        }
    }

    // Iterative function to delete a node
    public void delete(int data) {
        Tree parent = null;
        Tree current = root;

        // Find the node to be deleted and its parent
        while (current != null && current.data != data) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            // Node to be deleted not found
            return;
        }

        // Case 1: Node to be deleted has no children (leaf node)
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (current == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // Case 2: Node to be deleted has one child
        else if (current.left == null || current.right == null) {
            Tree child = (current.left != null) ? current.left : current.right;

            if (current == root) {
                root = child;
            } else if (current == parent.left) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // Case 3: Node to be deleted has two children
        else {
            // Find the in-order successor (smallest value in the right subtree)
            Tree successorParent = current;
            Tree successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Replace current node's value with successor's value
            current.data = successor.data;

            // Delete the successor node
            if (successorParent != current) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }
    }

    // Preorder traversal
    public void preorderTraversal(Tree node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // Inorder traversal
    public void inorderTraversal(Tree node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    // Postorder traversal
    public void postorderTraversal(Tree node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }
}

public class BinarySearchTree {
    public static void main(String[] args) {
        binarysearchtrees tree = new binarysearchtrees();

        // Inserting nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the tree:");
        tree.inorderTraversal(tree.root);
        System.out.println();

        System.out.println("Preorder traversal of the tree:");
        tree.preorderTraversal(tree.root);
        System.out.println();

        System.out.println("Deleting node 20:");
        tree.delete(20);
        tree.inorderTraversal(tree.root);
        System.out.println();

        System.out.println("Deleting node 50:");
        tree.delete(50);
        tree.inorderTraversal(tree.root);
        System.out.println();
    }
}
